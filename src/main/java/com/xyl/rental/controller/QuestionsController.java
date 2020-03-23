package com.xyl.rental.controller;

import com.xyl.rental.entity.Questions;
import com.xyl.rental.service.QuestionsService;
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

}