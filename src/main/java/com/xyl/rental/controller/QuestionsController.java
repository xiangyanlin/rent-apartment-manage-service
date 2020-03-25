package com.xyl.rental.controller;

import com.xyl.rental.entity.Questions;
import com.xyl.rental.service.QuestionsService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Questions)表控制层
 *
 * @author makejava
 * @since 2020-03-23 22:32:24
 */
@RestController
@RequestMapping("questions")
public class QuestionsController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionsService questionsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Questions selectOne(Integer id) {
        return this.questionsService.queryById(id);
    }

    /**
     * 根据id删除问答
     * @param id
     */
    @DeleteMapping("delete")
    @ResponseBody
    public R removeQuestions(@RequestParam("id") int id) {
        System.err.println(id);
        boolean b = questionsService.deleteById(id);
        return R.success(b,"success");
    }
    /**
     * 问答列表
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Questions condition, String keyWord){

        //System.out.println(keyWord);
        TableResult tableResult = this.questionsService.queryByPage(
                currentPage, pageSize,condition,keyWord);
        return tableResult;
    }

}