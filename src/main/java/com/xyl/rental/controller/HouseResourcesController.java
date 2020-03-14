package com.xyl.rental.controller;

import com.xyl.rental.entity.HouseResources;
import com.xyl.rental.service.HouseResourcesService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.PageInfo;
import com.xyl.rental.vo.TableResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房源表(HouseResources)表控制层
 *
 * @author makejava
 * @since 2020-03-05 14:00:15
 */
@RestController
@RequestMapping("houseResources")
@Slf4j
public class HouseResourcesController {
    /**
     * 服务对象
     */
    @Resource
    private HouseResourcesService houseResourcesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HouseResources selectOne(Integer id) {
        return this.houseResourcesService.queryById(id);
    }

    /**
     * 新增房源
     *
     * @return
     */
    @RequestMapping("save")
    public R saveHouseResources(@RequestBody HouseResources houseResources) {

        HouseResources insert = houseResourcesService.insert(houseResources);
        return R.success(insert);
    }

    @RequestMapping("update")
    public R updateHouseResources(@RequestBody HouseResources houseResources) {

        HouseResources update = houseResourcesService.update(houseResources);
        return R.success(update);
    }

    /**
     * 列表房源
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,HouseResources queryCondition) {
        //log.info(queryCondition);
        TableResult tableResult = this.houseResourcesService.queryByPage(currentPage, pageSize,queryCondition);
        return tableResult;
    }

}