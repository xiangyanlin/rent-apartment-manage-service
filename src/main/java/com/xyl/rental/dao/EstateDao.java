package com.xyl.rental.dao;

import com.xyl.rental.entity.Estate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 楼盘表(Estate)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-05 11:00:24
 */
@Mapper
public interface EstateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Estate queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Estate> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param estate 实例对象
     * @return 对象列表
     */
    List<Estate> queryAll(Estate estate);

    /**
     * 新增数据
     *
     * @param estate 实例对象
     * @return 影响行数
     */
    int insert(Estate estate);

    /**
     * 修改数据
     *
     * @param estate 实例对象
     * @return 影响行数
     */
    int update(Estate estate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询总数
     * @param queryCondition
     * @param keyWord
     * @return
     */
    int countTotal( Estate queryCondition, String keyWord);

    /**
     * 楼盘列表分页条件查询
     * @param offset
     * @param limit
     * @param queryCondition
     * @param keyWord
     * @return
     */
    List<Estate> queryPage(@Param("offset") int offset, @Param("limit") int limit, Estate queryCondition, String keyWord);

    /**
     * 统计楼盘总数
     * @return
     */
    int countEstateTotal();
}