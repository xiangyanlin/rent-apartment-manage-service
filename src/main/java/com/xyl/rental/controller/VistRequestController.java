package com.xyl.rental.controller;

import com.xyl.rental.entity.VistRequest;
import com.xyl.rental.service.VistRequestService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (VistRequest)表控制层
 *
 * @author xyl
 * @since 2020-03-15 18:56:10
 */
@Api(description = "看房请求操作接口")
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
    @ApiOperation(value = "通过主键查询单条看房请求数据")
    @GetMapping("selectOne")
    public VistRequest selectOne(Integer id) {
        return this.vistRequestService.queryById(id);
    }

    /**
     * 新增看房请求
     * @param vistRequest
     * @return
     */
    @ApiOperation(value = "新增看房请求")
    @RequestMapping("save")
    @ResponseBody
    public R saveVistRequest(@RequestBody VistRequest vistRequest) {
       // vistRequest.setCreated(new Date());
        VistRequest insert = vistRequestService.insert(vistRequest);
        return R.success(insert);
    }

    /**
     * 删除看房请求
     * @param id
     * @return
     */
    @ApiOperation(value = "删除看房请求")
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteVistRequest(@RequestParam("id") int id) {
        //System.err.println(id);
        boolean b = vistRequestService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 修改看房请求
     * @param vistRequest
     * @return
     */
    @ApiOperation(value = "修改看房请求")
    @RequestMapping("update")
    @ResponseBody
    public R updateHouseResources(@RequestBody VistRequest vistRequest) {
        System.out.println(vistRequest);
        VistRequest update = vistRequestService.update(vistRequest);
        return R.success(update);
    }

    /**
     * 请求列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询看房请求列表", notes="分页条件关键字查询看房请求列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            VistRequest queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.vistRequestService.queryByPage(
                currentPage, pageSize,  queryCondition,  keyWord);
        return tableResult;
    }

    /**
     * 看房请求
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "联合用户分页查询看房请求列表", notes="联合用户分页条件关键字查询看房请求列表")
    @GetMapping("requestList")
    @ResponseBody
    public TableResult requestList(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                                    @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                                    VistRequest queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.vistRequestService.queryRequestListByPage(
                currentPage, pageSize,  queryCondition,  keyWord);
        return tableResult;
    }

}