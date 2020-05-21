package com.xyl.rental.controller;

import com.xyl.rental.entity.Contract;
import com.xyl.rental.service.ContractService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Contract)表控制层
 *
 * @author xyl
 * @since 2020-03-15 23:03:42
 */
@Api(description = "合约操作接口")
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
    @ApiOperation(value = "通过id查找合约", notes="通过id查找单个合约")
    @GetMapping("selectOne")
    public Contract selectOne(Integer id) {
        return this.contractService.queryById(id);
    }

    /**
     * 新增合同
     * @param contract
     * @return
     */
    @ApiOperation(value = "新增合约", notes="新增合约")
    @RequestMapping("save")
    @ResponseBody
    public R saveRContract(@RequestBody Contract contract) {
        Contract insert = contractService.insert(contract);
        return R.success(insert);
    }

    /**
     * 根据ID删除和同
     * @param id
     * @return
     */
    @ApiOperation(value = "删除合约", notes="通过id删除单个合约")
    @DeleteMapping("delete")
    @ResponseBody
    public R removeContract(@RequestParam("id") int id) {
        boolean b = contractService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 修改合同
     * @param contract
     * @return
     */
    @ApiOperation(value = "修改合约", notes="通过实体修改合约")
    @RequestMapping("update")
    @ResponseBody
    public R updateContract(@RequestBody Contract contract) {

        Contract update = contractService.update(contract);
        return R.success(update);
    }

    /**
     * 合约列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询合约", notes="分页条件关键字查询")
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