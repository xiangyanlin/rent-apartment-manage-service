package com.xyl.rental.service.impl;

import com.xyl.rental.entity.DictType;
import com.xyl.rental.dao.DictTypeDao;
import com.xyl.rental.service.DictTypeService;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DictType)表服务实现类
 *
 * @author xyl
 * @since 2020-04-19 22:26:35
 */
@Service("dictTypeService")
public class DictTypeServiceImpl implements DictTypeService {
    @Resource
    private DictTypeDao dictTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictType queryById(Integer id) {
        return this.dictTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DictType> queryAllByLimit(int offset, int limit) {
        return this.dictTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType insert(DictType dictType) {
        this.dictTypeDao.insert(dictType);
        return dictType;
    }

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType update(DictType dictType) {
        this.dictTypeDao.update(dictType);
        return this.queryById(dictType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dictTypeDao.deleteById(id) > 0;
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
    public TableResult queryByPage(int currentPage, int pageSize, DictType queryCondition, String keyWord) {
        return null;
    }

    /**
     * 查询所有
     * @param dictType
     * @return
     */
    @Override
    public List queryAll(DictType dictType) {
        return dictTypeDao.queryAll(dictType);
    }
}