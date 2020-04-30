package com.xyl.rental.service;

import com.xyl.rental.entity.Role;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * 角色信息表(Role)表服务接口
 *
 * @author xyl
 * @since 2020-04-30 11:15:52
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 角色列表
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize, Role condition, String keyWord);

}