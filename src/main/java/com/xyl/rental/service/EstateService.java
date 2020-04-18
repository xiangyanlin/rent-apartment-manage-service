package com.xyl.rental.service;

import com.xyl.rental.entity.Estate;
import com.xyl.rental.vo.TableResult;

import java.util.List;
import java.util.Map;

/**
 * 楼盘表(Estate)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 11:00:25
 */
public interface EstateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Estate queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Estate> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有
     * @return
     */
    public List queryAll(Estate estate);
    /**
     * 新增数据
     *
     * @param estate 实例对象
     * @return 实例对象
     */
    Estate insert(Estate estate);

    /**
     * 修改数据
     *
     * @param estate 实例对象
     * @return 实例对象
     */
    Estate update(Estate estate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 楼盘列表
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize, Estate queryCondition, String keyWord);
}