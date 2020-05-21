package com.xyl.rental.controller;

import com.xyl.rental.entity.RentRecord;
import com.xyl.rental.service.RentRecordService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RentRecord)表控制层
 *
 * @author xyl
 * @since 2020-03-15 22:52:32
 */
@Api(description = "租房记录操作接口")
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
    @ApiOperation(value = "通过主键查询单条租房记录数据")
    @GetMapping("selectOne")
    public RentRecord selectOne(Integer id) {
        return this.rentRecordService.queryById(id);
    }

    /**
     * 新增记录
     * @param rentRecord
     * @return
     */
    @ApiOperation(value = "新增租房记录")
    @RequestMapping("save")
    @ResponseBody
    public R saveRecord(@RequestBody RentRecord rentRecord) {
        RentRecord insert = rentRecordService.insert(rentRecord);
        return R.success(insert);
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除租房记录", notes="根据id删除单个租房记录")
    @DeleteMapping("delete")
    @ResponseBody
    public R removeRecord(@RequestParam("id") int id) {
        boolean b = rentRecordService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 修改租房记录
     * @param rentRecord
     * @return
     */
    @ApiOperation(value = "修改租房记录")
    @RequestMapping("update")
    @ResponseBody
    public R updateRecord(@RequestBody RentRecord rentRecord) {

        RentRecord update = rentRecordService.update(rentRecord);
        return R.success(update);
    }

    /**
     * 租房记录列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询租房巨鹿列表", notes="分页条件关键字查询租房记录列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){

        // System.out.println(queryCondition);
        TableResult tableResult = this.rentRecordService.queryByPage(
                currentPage, pageSize);
        return tableResult;
    }
    /**
     * 租房记录列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询租房管理列表", notes="联表查询")
    @GetMapping("manage")
    @ResponseBody
    public TableResult manage(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){

        // System.out.println(queryCondition);
        TableResult tableResult = this.rentRecordService.recordList(
                currentPage, pageSize);
        return tableResult;
    }
}