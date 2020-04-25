package com.xyl.rental.service;

import com.xyl.rental.entity.Dict;
import com.xyl.rental.vo.TableResult;

import java.util.List;
import java.util.Map;

/**
 * (Dict)表服务接口
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
public interface DictService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dict queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dict> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict insert(Dict dict);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict update(Dict dict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 字典列表分页条件查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize, Dict queryCondition, String keyWord);

    Map<Object,Object> queryDict (List<Integer> typeIds);
}