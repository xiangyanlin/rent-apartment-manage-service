package com.xyl.rental.dao;

import com.xyl.rental.entity.HouseResources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 房源表(HouseResources)表数据库访问层
 *
 * @author xyl
 * @since 2020-03-05 14:00:15
 */
@Mapper
public interface HouseResourcesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HouseResources queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HouseResources> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 分页条件查询
     * @param offset
     * @param limit
     * @param houseResources
     * @param minRent
     * @param maxRent
     * @return
     */
    List<HouseResources> queryPage(@Param("offset") int offset, @Param("limit") int limit,HouseResources houseResources,String keyWord, Integer minRent, Integer maxRent);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param houseResources 实例对象
     * @return 对象列表
     */
    List<HouseResources> queryAll(HouseResources houseResources);

    /**
     * 新增数据
     *
     * @param houseResources 实例对象
     * @return 影响行数
     */
    int insert(HouseResources houseResources);

    /**
     * 修改数据
     *
     * @param houseResources 实例对象
     * @return 影响行数
     */
    int update(HouseResources houseResources);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *
     * @return
     */
    int countTotal(HouseResources houseResources, String keyWord,Integer minRent, Integer maxRent);

    List<Map> queryPageAndEstate(int offset, int limit, HouseResources houseResources, String keyWord, Integer minRent, Integer maxRent);

    /**
     * 统计房源组数
     * @return
     */
    int countHouseTotal();
}