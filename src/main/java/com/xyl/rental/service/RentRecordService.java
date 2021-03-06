package com.xyl.rental.service;

import com.xyl.rental.entity.RentRecord;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * (RentRecord)表服务接口
 *
 * @author xyl
 * @since 2020-03-15 22:52:32
 */
public interface RentRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RentRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RentRecord> queryAllByLimit(int offset, int limit);
    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    TableResult queryByPage(int currentPage, int pageSize);
    /**
     * 租房管理
     * @param currentPage
     * @param pageSize
     * @return
     */
    TableResult recordList(int currentPage, int pageSize);
    /**
     * 新增数据
     *
     * @param rentRecord 实例对象
     * @return 实例对象
     */
    RentRecord insert(RentRecord rentRecord);

    /**
     * 修改数据
     *
     * @param rentRecord 实例对象
     * @return 实例对象
     */
    RentRecord update(RentRecord rentRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}