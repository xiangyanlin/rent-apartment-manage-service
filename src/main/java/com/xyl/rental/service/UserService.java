package com.xyl.rental.service;

import com.xyl.rental.entity.User;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author xyl
 * @since 2020-03-15 19:55:27
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);
    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize,User queryCondition,String keyWord);
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据实体查询
     * @param condition
     * @return
     */
    User queryByUser(User condition);

    /**
     * 统计用户总数
     * @return
     */
    int countUserTotal();

    /**
     * 按月查询用户数量
     * @return
     */
    List<Map<Object, Object>> countUserByMon(Date startTime, Date endTime);

    /**
     * 发送邮箱验证码
     * @param user
     * @param operation
     * @return
     */
    R<Map<String, Object>> sendVerification(User user, String operation);

    /**
     * 邮箱验证码修改密码
     * @param user
     * @param newPassword
     * @param code
     * @param operation
     * @return
     */
    R<Map<String, Object>> updatePWByVerificationCode(User user, String newPassword,String code,String operation);

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    List<User> queryAllByCondition(User user);

    /**
     *邮箱验证码验证
     * @param code
     * @param operation
     * @return
     */
    R<Map<String, Object>> verificationCheck(String email,String code, String operation);
}