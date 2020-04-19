package com.xyl.rental.dao;

import com.xyl.rental.entity.VistRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (VistRequest)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-15 18:56:10
 */
@Mapper
public interface VistRequestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VistRequest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VistRequest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vistRequest 实例对象
     * @return 对象列表
     */
    List<VistRequest> queryAll(VistRequest vistRequest);

    /**
     * 新增数据
     *
     * @param vistRequest 实例对象
     * @return 影响行数
     */
    int insert(VistRequest vistRequest);

    /**
     * 修改数据
     *
     * @param vistRequest 实例对象
     * @return 影响行数
     */
    int update(VistRequest vistRequest);

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
    List<VistRequest> queryPage(@Param("offset") int offset, @Param("limit") int limit, VistRequest queryCondition, String keyWord);

    /**
     * 查询总数
     * @return
     */
    int countTotal( VistRequest queryCondition, String keyWord);

    /**
     * 请求列表联合楼盘表
     * @param offset
     * @param limit
     * @return
     */
    List<Map> queryRequestListByPage(@Param("offset") int offset, @Param("limit") int limit, VistRequest queryCondition, String keyWord);
}