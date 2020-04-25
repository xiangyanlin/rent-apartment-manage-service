package com.xyl.rental.dao;

import com.xyl.rental.entity.Dict;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Dict)表数据库访问层
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
public interface DictDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dict queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dict> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dict 实例对象
     * @return 对象列表
     */
    List<Dict> queryAll(Dict dict);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 影响行数
     */
    int insert(Dict dict);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 影响行数
     */
    int update(Dict dict);

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
    int countTotal( Dict queryCondition, String keyWord);

    /**
     * 字典列表分页条件查询
     * @param offset
     * @param limit
     * @param queryCondition
     * @param keyWord
     * @return
     */
    List<Dict> queryPage(@Param("offset") int offset, @Param("limit") int limit, Dict queryCondition, String keyWord);

}