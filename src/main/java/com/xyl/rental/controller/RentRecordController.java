package com.xyl.rental.controller;

import com.xyl.rental.entity.RentRecord;
import com.xyl.rental.service.RentRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RentRecord)表控制层
 *
 * @author makejava
 * @since 2020-03-15 22:52:32
 */
@RestController
@RequestMapping("rentRecord")
public class RentRecordController {
    /**
     * 服务对象
     */
    @Resource
    private RentRecordService rentRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RentRecord selectOne(Integer id) {
        return this.rentRecordService.queryById(id);
    }

}