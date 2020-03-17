package com.xyl.rental.service.impl;

import com.xyl.rental.entity.VistRequest;
import com.xyl.rental.dao.VistRequestDao;
import com.xyl.rental.service.VistRequestService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VistRequest)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 18:56:10
 */
@Service("vistRequestService")
public class VistRequestServiceImpl implements VistRequestService {
    @Resource
    private VistRequestDao vistRequestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VistRequest queryById(Integer id) {
        return this.vistRequestDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<VistRequest> queryAllByLimit(int offset, int limit) {
        return this.vistRequestDao.queryAllByLimit(offset, limit);
    }

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=vistRequestDao.countTotal();
        List<VistRequest> list = vistRequestDao.queryPage(
                start, pageSize);
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
     * @param vistRequest 实例对象
     * @return 实例对象
     */
    @Override
    public VistRequest insert(VistRequest vistRequest) {
        this.vistRequestDao.insert(vistRequest);
        return vistRequest;
    }

    /**
     * 修改数据
     *
     * @param vistRequest 实例对象
     * @return 实例对象
     */
    @Override
    public VistRequest update(VistRequest vistRequest) {
        this.vistRequestDao.update(vistRequest);
        return this.queryById(vistRequest.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.vistRequestDao.deleteById(id) > 0;
    }
}