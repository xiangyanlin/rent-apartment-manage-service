package com.xyl.rental.controller;

import com.xyl.rental.entity.DictType;
import com.xyl.rental.service.DictTypeService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DictType)表控制层
 *
 * @author xyl
 * @since 2020-04-19 22:26:35
 */
@Api(tags  = "字典类型操作接口")
@RestController
@RequestMapping("dictType")
public class DictTypeController {
    /**
     * 服务对象
     */
    @Resource
    private DictTypeService dictTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DictType selectOne(Integer id) {
        return this.dictTypeService.queryById(id);
    }

    /**
     * 新增字典类型
     * @param dictType
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public R saveDictType(@RequestBody DictType dictType) {

        DictType insert = dictTypeService.insert(dictType);
        return R.success(insert);
    }

    /**
     * 修改字典类型
     * @param dictType
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public R updateDictType(@RequestBody DictType dictType) {

        DictType update = dictTypeService.update(dictType);
        return R.success(update);
    }

    /**
     * 删除字典类型
     * @param id
     * @return
     */
    @DeleteMapping("delete")
    @ResponseBody
    public R deleteDictType(@RequestParam("id") int id) {
        boolean b = dictTypeService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 字典类型列表
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
                            DictType queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.dictTypeService.queryByPage(
                currentPage, pageSize,queryCondition,keyWord);
        return tableResult;
    }

    /**
     * 获取全部字典类型
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAll")
    public R selectAll(){
        List estates = this.dictTypeService.queryAll(null);
        return R.success(estates);
    }
}