package com.xyl.rental.controller;

import com.xyl.rental.entity.VistRequest;
import com.xyl.rental.service.VistRequestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (VistRequest)表控制层
 *
 * @author makejava
 * @since 2020-03-15 18:56:10
 */
@RestController
@RequestMapping("vistRequest")
public class VistRequestController {
    /**
     * 服务对象
     */
    @Resource
    private VistRequestService vistRequestService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public VistRequest selectOne(Integer id) {
        return this.vistRequestService.queryById(id);
    }

}