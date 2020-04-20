package com.xyl.rental.controller;

import com.xyl.rental.entity.Dict;
import com.xyl.rental.service.DictService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dict)表控制层
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
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
    @GetMapping("selectOne")
    public Dict selectOne(Integer id) {
        return this.dictService.queryById(id);
    }

    /**
     * 新增字典
     * @param dict
     * @return
     */
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


}