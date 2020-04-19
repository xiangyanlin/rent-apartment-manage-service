package com.xyl.rental.dao;

import com.xyl.rental.entity.Questions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Questions)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-23 22:32:24
 */
@Mapper
public interface QuestionsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Questions queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Questions> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param questions 实例对象
     * @return 对象列表
     */
    List<Questions> queryAll(Questions questions);

    /**
     * 新增数据
     *
     * @param questions 实例对象
     * @return 影响行数
     */
    int insert(Questions questions);

    /**
     * 修改数据
     *
     * @param questions 实例对象
     * @return 影响行数
     */
    int update(Questions questions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 分页条件关键字
     * @param offset
     * @param limit
     * @return
     */
    List<Questions> queryPage(@Param("offset") int offset, @Param("limit") int limit,Questions condition,String keyWord);

    /**
     * 查询总数
     * @return
     */
    int countTotal(Questions condition,String keyWord);

}