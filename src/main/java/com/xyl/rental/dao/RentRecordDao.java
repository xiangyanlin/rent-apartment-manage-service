package com.xyl.rental.dao;

import com.xyl.rental.entity.RentRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (RentRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-15 22:52:32
 */
@Mapper
public interface RentRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RentRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RentRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rentRecord 实例对象
     * @return 对象列表
     */
    List<RentRecord> queryAll(RentRecord rentRecord);

    /**
     * 新增数据
     *
     * @param rentRecord 实例对象
     * @return 影响行数
     */
    int insert(RentRecord rentRecord);

    /**
     * 修改数据
     *
     * @param rentRecord 实例对象
     * @return 影响行数
     */
    int update(RentRecord rentRecord);

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
    List<RentRecord> queryPage(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询总数
     * @return
     */
    int countTotal();
    /**
     * 分页记录
     * @param offset
     * @param limit
     * @return
     */
    List<Map<String,Object>> recordList(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 记录总数
     * @return
     */
    int recordTotal();
}