package com.xyl.rental.service;

import com.xyl.rental.entity.HouseResources;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * 房源表(HouseResources)表服务接口
 *
 * @author xyl
 * @since 2020-03-05 14:00:15
 */

public interface HouseResourcesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HouseResources queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HouseResources> queryAllByLimit(int offset, int limit);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize,HouseResources queryCondition,String keyWord,Integer minRent, Integer maxRent);

    /**
     * 新增数据
     *
     * @param houseResources 实例对象
     * @return 实例对象
     */
    HouseResources insert(HouseResources houseResources);

    /**
     * 修改数据
     *
     * @param houseResources 实例对象
     * @return 实例对象
     */
    HouseResources update(HouseResources houseResources);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 联合楼盘查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @param minRent
     * @param maxRent
     * @return
     */
    TableResult queryPageAndEstate(int currentPage, int pageSize,HouseResources queryCondition,
                                   String keyWord,Integer minRent, Integer maxRent);

}