package com.xyl.rental.controller;

import com.xyl.rental.entity.Information;
import com.xyl.rental.service.InformationService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Information)表控制层
 *
 * @author xyl
 * @since 2020-03-15 23:10:02
 */
@Api(tags  = "资讯操作接口")
@RestController
@RequestMapping("information")
public class InformationController {
    /**
     * 服务对象
     */
    @Resource
    private InformationService informationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条资讯数据", notes="通过主键查询单条资讯数据")
    @GetMapping("selectOne")
    public Information selectOne(Integer id) {
        return this.informationService.queryById(id);
    }


    /**
     * 新增资讯
     * @param information
     * @return
     */
    @ApiOperation(value = "新增资讯", notes="通过实体新增资讯")
    @RequestMapping("save")
    @ResponseBody
    public R saveInformation(@RequestBody Information information) {
        Information insert = informationService.insert(information);
        return R.success(insert);
    }

    /**
     * 修改资讯
     * @param information
     * @return
     */
    @ApiOperation(value = "修改资讯", notes="通过实体修改资讯信息")
    @RequestMapping("update")
    @ResponseBody
    public R updateInformation(@RequestBody Information information) {

        Information update = informationService.update(information);
        return R.success(update);
    }

    /**
     * 删除资讯
     * @param id
     */
    @ApiOperation(value = "删除资讯", notes="通过id删除资讯")
    @DeleteMapping("delete")
    @ResponseBody
    public R removeInformation(@RequestParam("id") int id) {
        //System.err.println(id);
        boolean b = informationService.deleteById(id);
        return R.success(b,"success");

    }
    /**
     * 资讯列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询资讯列表", notes="分页条件关键字查询资讯列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Information condition,String keyWord){

         //System.out.println(keyWord);
        TableResult tableResult = this.informationService.queryByPage(
                currentPage, pageSize,condition,keyWord );
        return tableResult;
    }


}