package com.xyl.rental.controller;

import com.xyl.rental.entity.Information;
import com.xyl.rental.service.InformationService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Information)表控制层
 *
 * @author makejava
 * @since 2020-03-15 23:10:02
 */
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
    @GetMapping("selectOne")
    public Information selectOne(Integer id) {
        return this.informationService.queryById(id);
    }

    /**
     * 删除资讯
     * @param id
     */
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