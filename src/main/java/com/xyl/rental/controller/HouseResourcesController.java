package com.xyl.rental.controller;

import com.xyl.rental.query.HouseQuery;
import com.xyl.rental.entity.HouseResources;
import com.xyl.rental.service.HouseResourcesService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 房源表(HouseResources)表控制层
 *
 * @author xyl
 * @since 2020-03-05 14:00:15
 */
@Api(description = "房源操作接口")
@RestController
@RequestMapping("houseResources")
@Slf4j
public class HouseResourcesController {
    /**
     * 服务对象
     */
    @Resource
    private HouseResourcesService houseResourcesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "获取房源", notes="通过id获取单个房源")
    @GetMapping("selectOne")
    public HouseResources selectOne(Integer id) {
        return this.houseResourcesService.queryById(id);
    }

    /**
     * 新增房源
     *
     * @return
     */
    @ApiOperation(value = "新增房源")
    @RequestMapping("save")
    public R saveHouseResources(@RequestBody HouseResources houseResources) {
        houseResources.setCreated(new Date());
        HouseResources insert = houseResourcesService.insert(houseResources);
        return R.success(insert);
    }

    /**
     * 修改房源
     * @param houseResources
     * @return
     */
    @ApiOperation(value = "修改房源信息", notes="传入房源实体")
    @RequestMapping("update")
    @ResponseBody
    public R updateHouseResources(@RequestBody HouseResources houseResources) {
        Date date=new Date();
        houseResources.setUpdated(date);
        //System.err.println(date);
        HouseResources update = houseResourcesService.update(houseResources);
        return R.success(update);
    }

    /**
     * 根据id删除房源
     * @param id
     */
    @ApiOperation(value = "删除房源", notes="通过id删除单个房源")
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteHouseResources(@RequestParam("id") int id) {
        //System.err.println(id);
        boolean b = houseResourcesService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 列表房源
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询房源列表", notes="条件关键字查询")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            HouseQuery queryCondition){
        TableResult tableResult = this.houseResourcesService.queryByPage(
                currentPage, pageSize,queryCondition);
        return tableResult;
    }

    /**
     * 联合楼盘查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @return
     */
    @ApiOperation(value = "分页查询房源列表", notes="联合楼盘查询")
    @GetMapping("andEstateList")
    @ResponseBody
    public TableResult andEstateList(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            HouseQuery queryCondition){

        TableResult tableResult = this.houseResourcesService.queryPageAndEstate(
                currentPage, pageSize,queryCondition);
        return tableResult;
    }

    /**
     * 统计房源总量
     * @return
     */
    @GetMapping("total")
    @ResponseBody
    public R countHouseTotal(){
        int houses = houseResourcesService.countHouseTotal();
        return R.success(houses);
    }


    /**
     * 精装房占比
     * @return
     */
    @GetMapping("decorationProp")
    @ResponseBody
    public R decorationProp(){
        Double prop = houseResourcesService.decorationProp();
        return R.success(prop);
    }

    /**
     * 按朝向查找
     * @return
     */
    @GetMapping("countByO")
    @ResponseBody
    public R countByO(){
        List<Map<Object, Object>> maps = houseResourcesService.countHouseByO();
        return R.success(maps);
    }
}