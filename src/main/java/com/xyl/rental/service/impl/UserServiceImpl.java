package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Email;
import com.xyl.rental.entity.User;
import com.xyl.rental.dao.UserDao;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.DateUtils;
import com.xyl.rental.utils.MailUtil;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * (User)表服务实现类
 *
 * @author xyl
 * @since 2020-03-15 19:55:27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private MailUtil mailUtil;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize,User queryCondition,String keyWord) {

            TableResult tr=new TableResult();
            Pagination pagination=new Pagination();
            int start=(currentPage-1)*pageSize;
            int total=userDao.countTotal(queryCondition,keyWord);
            List<User> list = userDao.queryPage(
                    start, pageSize,queryCondition,keyWord);
            pagination.setCurrent(currentPage);
            pagination.setPageSize(pageSize);
            pagination.setTotal(total);
            tr.setList(list);
            tr.setPagination(pagination);
            return tr;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public User queryByUser(User condition) {
        User user=null;
        List<User> users = this.userDao.queryAll(condition);
        //System.out.println(users);
        if(null!=users&&users.size()!=0){
             user=users.get(0);
        }

        return user;
    }

    /**
     * 统计用户总数
     * @return
     */
    @Override
    public int countUserTotal() {
        return userDao.countUserTotal();
    }

    /**
     * 按月查询用户数量
     * @return
     */
    @Override
    public List<Map<Object, Object>> countUserByMon(Date startTime, Date endTime) {
        return userDao.countUserByMon(startTime,endTime);
    }

    /**
     * 发送验证码
     * @param user
     * @param operation
     * @return
     */
    @Override
    public R<Map<String, Object>> sendVerification(User user, String operation) {
        Random random = new Random();
        Map<String, Object> rmap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        String content = "";
        int retime = DateUtils.remainingTime();
        for (int i = 0; i < 6; i++) {
            int temp = random.nextInt(10);
            content += temp;
        }
        if (operation == null) {
            operation = "";
        }
        String key = user.getEmail() + operation + "check";
        String check = template.opsForValue().get(key);
        if (check != null) {
            if (Integer.parseInt(check) >= 3) {
                template.expire(key, retime, TimeUnit.SECONDS);
                return R.failed("您今天已连续发送三次验证码，账号今天已锁定");
            } else {
                template.opsForValue().increment(key);
            }
        } else {
            template.opsForValue().set(key, "1");
        }
        rmap.put(operation + "password", content);
        rmap.put("count", "0");
        template.opsForHash().putAll(user.getEmail(), rmap);
        mailUtil.sendSimpleMail(new Email(user.getEmail(), "验证码邮件", "验证码为: " + content + " 五分钟内有效"));
        template.expire(user.getEmail(), 300, TimeUnit.SECONDS);
        return R.success(map, "信息发送成功");
    }
}