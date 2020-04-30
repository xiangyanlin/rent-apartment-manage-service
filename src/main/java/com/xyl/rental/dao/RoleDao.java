package com.xyl.rental.dao;

import com.xyl.rental.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author xyl
 * @since 2020-04-30 11:15:52
 */
@Mapper
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
    List<Role> queryAll(Role role);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询条数
     * @param condition
     * @param keyWord
     * @return
     */
    int countTotal(Role condition, String keyWord);

    /**
     * 分页
     * @param offset
     * @param limit
     * @param condition
     * @param keyWord
     * @return
     */
    List<Role> queryPage(@Param("offset") int offset, @Param("limit") int limit,Role condition,String keyWord);

}