package com.xyl.rental.dao;

import com.xyl.rental.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Contract)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-15 23:03:42
 */
@Mapper
public interface ContractDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Contract queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Contract> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param contract 实例对象
     * @return 对象列表
     */
    List<Contract> queryAll(Contract contract);

    /**
     * 新增数据
     *
     * @param contract 实例对象
     * @return 影响行数
     */
    int insert(Contract contract);

    /**
     * 修改数据
     *
     * @param contract 实例对象
     * @return 影响行数
     */
    int update(Contract contract);

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
    List<Contract> queryPage(@Param("offset") int offset, @Param("limit") int limit,Contract condition,String keyWord);

    /**
     * 查询总数
     * @return
     */
    int countTotal(Contract condition,String keyWord);
}