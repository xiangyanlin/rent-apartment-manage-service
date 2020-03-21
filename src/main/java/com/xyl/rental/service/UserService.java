package com.xyl.rental.service;

import com.xyl.rental.entity.User;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
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

}