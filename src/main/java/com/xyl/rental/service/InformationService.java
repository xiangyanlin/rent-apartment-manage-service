package com.xyl.rental.service;

import com.xyl.rental.entity.Information;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * (Information)表服务接口
 *
 * @author xyl
 * @since 2020-03-15 23:10:02
 */
public interface InformationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Information queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Information> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    Information insert(Information information);

    /**
     * 修改数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    Information update(Information information);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize,Information condition,String keyWord);

}