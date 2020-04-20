package com.xyl.rental.service;

import com.xyl.rental.entity.DictType;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * (DictType)表服务接口
 *
 * @author xyl
 * @since 2020-04-19 22:26:35
 */
public interface DictTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType insert(DictType dictType);

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType update(DictType dictType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 字典类型
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize, DictType queryCondition, String keyWord);

    /**
     * 查询所有
     * @return
     */
    public List queryAll(DictType dictType);
}