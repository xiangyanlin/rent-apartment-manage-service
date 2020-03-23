package com.xyl.rental.controller;

import com.xyl.rental.entity.Contract;
import com.xyl.rental.service.ContractService;
import com.xyl.rental.vo.TableResult;
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

    /**
     * 合约列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Contract condition,String keyWord){

        //System.out.println(keyWord);
        TableResult tableResult = this.contractService.queryByPage(
                currentPage, pageSize,condition,keyWord);
        return tableResult;
    }


}