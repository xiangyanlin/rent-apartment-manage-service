package com.xyl.rental.dao;

import com.xyl.rental.entity.DictType;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DictType)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-19 22:26:35
 */
public interface DictTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictType queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictType 实例对象
     * @return 对象列表
     */
    List<DictType> queryAll(DictType dictType);

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 影响行数
     */
    int insert(DictType dictType);

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 影响行数
     */
    int update(DictType dictType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}