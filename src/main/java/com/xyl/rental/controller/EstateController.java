package com.xyl.rental.controller;

import com.xyl.rental.entity.Estate;
import com.xyl.rental.service.EstateService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 楼盘表(Estate)表控制层
 *
 * @author makejava
 * @since 2020-03-05 11:00:29
 */
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
    @GetMapping("selectOne")
    public Estate selectOne(Integer id) {
        return this.estateService.queryById(id);
    }

    /**
     * 查询所有数据
     * @return
     */
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
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteHouseResources(@RequestParam("id") int id) {
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

}