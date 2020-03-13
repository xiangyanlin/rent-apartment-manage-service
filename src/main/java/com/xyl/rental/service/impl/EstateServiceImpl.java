package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Estate;
import com.xyl.rental.dao.EstateDao;
import com.xyl.rental.service.EstateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 楼盘表(Estate)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 11:00:25
 */
@Service("estateService")
public class EstateServiceImpl implements EstateService {
    @Resource
    private EstateDao estateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Estate queryById(Integer id) {
        return this.estateDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Estate> queryAllByLimit(int offset, int limit) {
        return this.estateDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List queryAll(Estate estate) {
        List<Estate> estates = this.estateDao.queryAll(estate);
        List list=new ArrayList();
        //Map<String,String> estateMap=new HashMap<String,String>();
        for (Estate state:estates) {
            List<String> list1=new ArrayList<String>();
            String key=state.getName();
            list1.add(key);
            String value=state.getId()+"|"+state.getProvince()+","+state.getCity()+","+state.getArea()+","+state.getAddress();
            list1.add(value);
            list.add(list1);

        }
        return list;
    }

    /**
     * 新增数据
     *
     * @param estate 实例对象
     * @return 实例对象
     */
    @Override
    public Estate insert(Estate estate) {
        this.estateDao.insert(estate);
        return estate;
    }

    /**
     * 修改数据
     *
     * @param estate 实例对象
     * @return 实例对象
     */
    @Override
    public Estate update(Estate estate) {
        this.estateDao.update(estate);
        return this.queryById(estate.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.estateDao.deleteById(id) > 0;
    }
}