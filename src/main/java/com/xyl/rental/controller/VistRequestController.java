package com.xyl.rental.controller;

import com.xyl.rental.entity.VistRequest;
import com.xyl.rental.service.VistRequestService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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

    /**
     * 新增看房请求
     * @param vistRequest
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public R saveHouseResources(@RequestBody VistRequest vistRequest) {
       // vistRequest.setCreated(new Date());
        VistRequest insert = vistRequestService.insert(vistRequest);
        return R.success(insert);
    }

    /**
     * 请求列表
     * @param currentPage
     * @param pageSize
     * @return
     */

    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){

        // System.out.println(queryCondition);
        TableResult tableResult = this.vistRequestService.queryByPage(
                currentPage, pageSize);
        return tableResult;
    }

    /**
     * 看房请求
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("requestList")
    @ResponseBody
    public TableResult requestList(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){

        // System.out.println(queryCondition);
        TableResult tableResult = this.vistRequestService.queryRequestListByPage(
                currentPage, pageSize);
        return tableResult;
    }

}