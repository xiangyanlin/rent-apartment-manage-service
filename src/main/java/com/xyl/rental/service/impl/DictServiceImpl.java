package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Dict;
import com.xyl.rental.dao.DictDao;
import com.xyl.rental.service.DictService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dict)表服务实现类
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
@Service("dictService")
public class DictServiceImpl implements DictService {
    @Resource
    private DictDao dictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dict queryById(Integer id) {
        return this.dictDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Dict> queryAllByLimit(int offset, int limit) {
        return this.dictDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict insert(Dict dict) {
        this.dictDao.insert(dict);
        return dict;
    }

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict update(Dict dict) {
        this.dictDao.update(dict);
        return this.queryById(dict.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dictDao.deleteById(id) > 0;
    }

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize, Dict queryCondition, String keyWord) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;

        int total=dictDao.countTotal(  queryCondition,  keyWord);
        List<Dict> list = dictDao.queryPage(
                start, pageSize,  queryCondition,  keyWord);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }
}