package com.xyl.rental.controller;

import com.xyl.rental.entity.Estate;
import com.xyl.rental.service.EstateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 楼盘表(Estate)表控制层
 *
 * @author makejava
 * @since 2020-03-05 11:00:29
 */
@RestController
@RequestMapping("estate")
public class EstateController {
    /**
     * 服务对象
     */
    @Resource
    private EstateService estateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Estate selectOne(Integer id) {
        return this.estateService.queryById(id);
    }

}