package com.xyl.rental.service.impl;

import com.xyl.rental.entity.User;
import com.xyl.rental.dao.UserDao;
import com.xyl.rental.service.UserService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 19:55:27
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

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
}