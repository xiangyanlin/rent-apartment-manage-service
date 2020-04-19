package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Contract;
import com.xyl.rental.dao.ContractDao;
import com.xyl.rental.service.ContractService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Contract)表服务实现类
 *
 * @author xyl
 * @since 2020-03-15 23:03:42
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractDao contractDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Contract queryById(Integer id) {
        return this.contractDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Contract> queryAllByLimit(int offset, int limit) {
        return this.contractDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param contract 实例对象
     * @return 实例对象
     */
    @Override
    public Contract insert(Contract contract) {
        this.contractDao.insert(contract);
        return contract;
    }

    /**
     * 修改数据
     *
     * @param contract 实例对象
     * @return 实例对象
     */
    @Override
    public Contract update(Contract contract) {
        this.contractDao.update(contract);
        return this.queryById(contract.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.contractDao.deleteById(id) > 0;
    }

    @Override
    public TableResult queryByPage(int currentPage, int pageSize, Contract condition,String keyWord) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=contractDao.countTotal(condition,keyWord);
        List<Contract> list = contractDao.queryPage(
                start, pageSize,condition,keyWord);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }
}