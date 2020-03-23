package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Information;
import com.xyl.rental.dao.InformationDao;
import com.xyl.rental.service.InformationService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Information)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 23:10:02
 */
@Service("informationService")
public class InformationServiceImpl implements InformationService {
    @Resource
    private InformationDao informationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Information queryById(Integer id) {
        return this.informationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Information> queryAllByLimit(int offset, int limit) {
        return this.informationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    @Override
    public Information insert(Information information) {
        this.informationDao.insert(information);
        return information;
    }

    /**
     * 修改数据
     *
     * @param information 实例对象
     * @return 实例对象
     */
    @Override
    public Information update(Information information) {
        this.informationDao.update(information);
        return this.queryById(information.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.informationDao.deleteById(id) > 0;
    }

    @Override
    public TableResult queryByPage(int currentPage, int pageSize,Information condition,String keyWord) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;

        int total=informationDao.countTotal(condition,keyWord);

        List<Information> list = informationDao.queryPage(start, pageSize,condition,keyWord);

        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }
}