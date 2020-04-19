package com.xyl.rental.controller;

import com.xyl.rental.entity.Dict;
import com.xyl.rental.service.DictService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Dict)表控制层
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
@RestController
@RequestMapping("dict")
public class DictController {
    /**
     * 服务对象
     */
    @Resource
    private DictService dictService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dict selectOne(Integer id) {
        return this.dictService.queryById(id);
    }

}