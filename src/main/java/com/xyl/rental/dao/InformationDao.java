package com.xyl.rental.dao;

import com.xyl.rental.entity.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Information)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-15 23:10:02
 */
@Mapper
public interface InformationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Information queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Information> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param information 实例对象
     * @return 对象列表
     */
    List<Information> queryAll(Information information);

    /**
     * 新增数据
     *
     * @param information 实例对象
     * @return 影响行数
     */
    int insert(Information information);

    /**
     * 修改数据
     *
     * @param information 实例对象
     * @return 影响行数
     */
    int update(Information information);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 分页查询
     * @param offset
     * @param limit
     * @return
     */
    List<Information> queryPage(@Param("offset") int offset, @Param("limit") int limit,Information condition,String keyWord);

    /**
     * 查询总数
     * @return
     */
    int countTotal(Information condition,String keyWord);
}