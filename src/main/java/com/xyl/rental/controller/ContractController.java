package com.xyl.rental.controller;

import com.xyl.rental.entity.Contract;
import com.xyl.rental.service.ContractService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Contract)表控制层
 *
 * @author makejava
 * @since 2020-03-15 23:03:42
 */
@RestController
@RequestMapping("contract")
public class ContractController {
    /**
     * 服务对象
     */
    @Resource
    private ContractService contractService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Contract selectOne(Integer id) {
        return this.contractService.queryById(id);
    }

}