package com.xyl.rental.service.impl;

import com.xyl.rental.entity.RentRecord;
import com.xyl.rental.dao.RentRecordDao;
import com.xyl.rental.service.RentRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RentRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 22:52:32
 */
@Service("rentRecordService")
public class RentRecordServiceImpl implements RentRecordService {
    @Resource
    private RentRecordDao rentRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RentRecord queryById(Integer id) {
        return this.rentRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RentRecord> queryAllByLimit(int offset, int limit) {
        return this.rentRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rentRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RentRecord insert(RentRecord rentRecord) {
        this.rentRecordDao.insert(rentRecord);
        return rentRecord;
    }

    /**
     * 修改数据
     *
     * @param rentRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RentRecord update(RentRecord rentRecord) {
        this.rentRecordDao.update(rentRecord);
        return this.queryById(rentRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rentRecordDao.deleteById(id) > 0;
    }
}