package com.xyl.rental.service.impl;

import com.xyl.rental.dto.HouseEatateDto;
import com.xyl.rental.query.HouseQuery;
import com.xyl.rental.entity.HouseResources;
import com.xyl.rental.dao.HouseResourcesDao;
import com.xyl.rental.service.HouseResourcesService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 房源表(HouseResources)表服务实现类
 *
 * @author xyl
 * @since 2020-03-05 14:00:15
 */
@Service("houseResourcesService")
public class HouseResourcesServiceImpl implements HouseResourcesService {
    @Resource
    private HouseResourcesDao houseResourcesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HouseResources queryById(Integer id) {
        return this.houseResourcesDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HouseResources> queryAllByLimit(int offset, int limit) {
        return this.houseResourcesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize, HouseQuery queryCondition) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=houseResourcesDao.countTotal(queryCondition);
        List<HouseResources> list = houseResourcesDao.queryPage(
                start, pageSize,queryCondition);
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
     * @param houseResources 实例对象
     * @return 实例对象
     */
    @Override
    public HouseResources insert(HouseResources houseResources) {
        this.houseResourcesDao.insert(houseResources);
        return houseResources;
    }

    /**
     * 修改数据
     *
     * @param houseResources 实例对象
     * @return 实例对象
     */
    @Override
    public HouseResources update(HouseResources houseResources) {
        this.houseResourcesDao.update(houseResources);
        return this.queryById(houseResources.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.houseResourcesDao.deleteById(id) > 0;
    }

    /**
     * 联合楼盘查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @return
     */
    @Override
    public TableResult queryPageAndEstate(int currentPage, int pageSize, HouseQuery queryCondition) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=houseResourcesDao.countTotal(queryCondition);

        List<HouseEatateDto> houseEatateDtos = houseResourcesDao.queryPageAndEstate(
                start, pageSize, queryCondition);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(houseEatateDtos);
        tr.setPagination(pagination);
        return tr;
    }

    /**
     * 统计房源总数
     * @return
     */
    @Override
    public int countHouseTotal() {
        return houseResourcesDao.countHouseTotal();
    }


    /**
     * 精装房占比
     * @return
     */
    @Override
    public Double decorationProp() {
        HouseQuery condition=new HouseQuery();
        condition.setDecoration(1);
        int total = houseResourcesDao.countHouseTotal();
        int i = houseResourcesDao.countTotal(condition);
        Double prop=(i/Double.valueOf(total))*100;
        BigDecimal bg = new BigDecimal(prop);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 按朝向统计房源
     * @return
     */
    @Override
    public List<Map<Object, Object>> countHouseByO() {
        return houseResourcesDao.countHouseByO();
    }
}