package com.xyl.rental.controller;

import com.xyl.rental.entity.Dict;
import com.xyl.rental.service.DictService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Dict)表控制层
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
@Api(description = "字典操作接口")
@RestController
@RequestMapping("dict")
public class DictController {
    /**
     * 服务对象
     */
    @Resource
    private DictService dictService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查找字典", notes="通过id查找单个字典")
    @GetMapping("selectOne")
    public Dict selectOne(Integer id) {
        return this.dictService.queryById(id);
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
    @ApiOperation(value = "新增字典", notes="新增字典")
    @RequestMapping("save")
    @ResponseBody
    public R saveDict(@RequestBody Dict dict) {
        Dict insert = dictService.insert(dict);
        return R.success(insert);
    }

    /**
     * 修改字典
     * @param dict
     * @return
     */
    @ApiOperation(value = "修改字典信息", notes="通过实体修改单个字典")
    @RequestMapping("update")
    @ResponseBody
    public R updateDict(@RequestBody Dict dict) {

        Dict update = dictService.update(dict);
        return R.success(update);
    }

    /**
     * 删除字典
     * @param id
     * @return
     */
    @ApiOperation(value = "删除字典", notes="通过id删除单个字典")
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteDict(@RequestParam("id") int id) {
        //System.err.println(id);
        boolean b = dictService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 字典列表
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    @ApiOperation(value = "分页查询字典列表", notes="分页条件关键字查询字典列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Dict queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.dictService.queryByPage(
                currentPage, pageSize,queryCondition,keyWord);
        return tableResult;
    }

    /**
     * 通过类型id数组获取字典
     * @param typeIds
     * @return
     */
    @ApiOperation(value = "通过类型id数组获取字典", notes="通过类型id数组获取字典")
    @RequestMapping("getDicts")
    @ResponseBody
    public R queryDic(@RequestBody List<Integer> typeIds){
        Map<Object, Object> dicts = dictService.queryDict(typeIds);
        return  R.success(dicts);
    }
}