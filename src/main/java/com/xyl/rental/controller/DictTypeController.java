package com.xyl.rental.controller;

import com.xyl.rental.entity.DictType;
import com.xyl.rental.service.DictTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DictType)表控制层
 *
 * @author makejava
 * @since 2020-04-19 22:26:35
 */
@RestController
@RequestMapping("dictType")
public class DictTypeController {
    /**
     * 服务对象
     */
    @Resource
    private DictTypeService dictTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DictType selectOne(Integer id) {
        return this.dictTypeService.queryById(id);
    }

}