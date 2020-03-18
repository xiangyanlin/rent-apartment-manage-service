package com.xyl.rental.service.impl;

import com.xyl.rental.entity.RentRecord;
import com.xyl.rental.dao.RentRecordDao;
import com.xyl.rental.service.RentRecordService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=rentRecordDao.countTotal();
        List<RentRecord> list = rentRecordDao.queryPage(
                start, pageSize);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }

    @Override
    public TableResult recordList(int currentPage, int pageSize) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=rentRecordDao.recordTotal();
        List<Map<String, Object>> maps = rentRecordDao.recordList(start, pageSize);
        List list=new ArrayList();
        for (Map map:maps) {
            if(map.get("status").equals("1")){
                map.put("state","已确认");
            }else if(map.get("status").equals("2")){
                map.put("state","待确认");
            }else if(map.get("status").equals("3")){
                map.put("state","待付款");
            }else{
                map.put("state","未知");
            }

            if(null!=map.get("startTime")&&null!=map.get("endTime")){
                map.put("time",map.get("startTime")+"—"+map.get("endTime"));
            }
            list.add(map);
        }

        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
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