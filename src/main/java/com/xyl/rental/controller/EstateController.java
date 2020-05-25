package com.xyl.rental.controller;

import com.xyl.rental.entity.Estate;
import com.xyl.rental.service.EstateService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 楼盘表(Estate)表控制层
 *
 * @author xyl
 * @since 2020-03-05 11:00:29
 */
@Api(tags  = "楼盘操作接口")
@RestController
@RequestMapping("estate")
public class EstateController {
    /**
     * 服务对象
     */
    @Resource
    private EstateService estateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条数据")
    @GetMapping("selectOne")
    public Estate selectOne(Integer id) {
        return this.estateService.queryById(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    @ApiOperation(value = "查询所有楼盘数据")
    @ResponseBody
    @RequestMapping("selectAll")
    public R selectAll(){
        List estates = this.estateService.queryAll(null);
        return R.success(estates);
    }

    /**
     * 新增楼盘
     *
     * @return
     */
    @ApiOperation(value = "新增楼盘", notes="新增楼盘")
    @RequestMapping("save")
    @ResponseBody
    public R saveEstate(@RequestBody Estate estate) {
        //houseResources.setCreated(new Date());
        Estate insert = estateService.insert(estate);
        return R.success(insert);
    }

    /**
     * 修改楼盘信息
     * @param estate
     * @return
     */
    @ApiOperation(value = "修改楼盘信息", notes="通过实体修改楼盘信息")
    @RequestMapping("update")
    @ResponseBody
    public R updateEstate(@RequestBody Estate estate) {

        //System.err.println(date);
        Estate update = estateService.update(estate);
        return R.success(update);
    }

    /**
     * 根据ID删除楼盘
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除楼盘", notes="根据ID删除单个楼盘")
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteEstate(@RequestParam("id") int id) {
        //System.err.println(id);
        boolean b = estateService.deleteById(id);
        return R.success(b,"success");
    }
    /**
     * 楼盘列表
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    @ApiOperation(value = "分页查询楼盘列表", notes="分页条件关键字查询楼盘列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Estate queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.estateService.queryByPage(
                currentPage, pageSize,queryCondition,keyWord);
        return tableResult;
    }

    /**
     * 统计楼盘总数
     * @return
     */
    @ApiOperation(value = "通过id查找字典", notes="通过id查找单个字典")
    @GetMapping("total")
    @ResponseBody
    public R countEstateTotal(){
        int users = estateService.countEstateTotal();
        return R.success(users);
    }

}