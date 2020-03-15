package com.xyl.rental.controller;

import com.xyl.rental.entity.Information;
import com.xyl.rental.service.InformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Information)表控制层
 *
 * @author makejava
 * @since 2020-03-15 23:10:02
 */
@RestController
@RequestMapping("information")
public class InformationController {
    /**
     * 服务对象
     */
    @Resource
    private InformationService informationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Information selectOne(Integer id) {
        return this.informationService.queryById(id);
    }

}