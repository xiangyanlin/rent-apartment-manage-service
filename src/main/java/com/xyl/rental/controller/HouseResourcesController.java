package com.xyl.rental.controller;

import com.xyl.rental.entity.HouseResources;
import com.xyl.rental.service.HouseResourcesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 房源表(HouseResources)表控制层
 *
 * @author makejava
 * @since 2020-03-05 14:00:15
 */
@RestController
@RequestMapping("houseResources")
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
     * @return
     */
    @RequestMapping("save")
    public HouseResources saveHouseResources(@RequestBody HouseResources houseResources){
        HouseResources insert = houseResourcesService.insert(houseResources);
        return insert;
    }

}