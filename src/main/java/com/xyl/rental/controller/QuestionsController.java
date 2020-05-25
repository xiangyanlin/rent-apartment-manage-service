package com.xyl.rental.controller;

import com.xyl.rental.entity.Questions;
import com.xyl.rental.service.QuestionsService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Questions)表控制层
 *
 * @author xyl
 * @since 2020-03-23 22:32:24
 */
@Api(tags  = "问答操作接口")
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
    @ApiOperation(value = "通过主键查询单条问答数据")
    @GetMapping("selectOne")
    public Questions selectOne(Integer id) {
        return this.questionsService.queryById(id);
    }

    /**
     * 新增问答
     * @param questions
     * @return
     */
    @ApiOperation(value = "新增问答")
    @RequestMapping("save")
    @ResponseBody
    public R saveQuestions(@RequestBody Questions questions) {
        Questions insert = questionsService.insert(questions);
        return R.success(insert);
    }

    /**
     * 修改问答
     * @param questions
     * @return
     */
    @ApiOperation(value = "修改问答")
    @RequestMapping("update")
    @ResponseBody
    public R updateQuestions(@RequestBody Questions questions) {

        Questions update = questionsService.update(questions);
        return R.success(update);
    }

    /**
     * 根据id删除问答
     * @param id
     */
    @ApiOperation(value = "根据id删除问答", notes="根据id删除单个问答")
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
    @ApiOperation(value = "分页查询问答列表", notes="分页条件关键字查询问答列表")
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

    /**
     * 联合用户名以及用户头像
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @ApiOperation(value = "联合用户名以及用户头像分页查询资讯列表")
    @GetMapping("qa")
    @ResponseBody
    public TableResult qa(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Questions condition, String keyWord){
        TableResult tableResult = this.questionsService.queryPageAndUser(
                currentPage, pageSize,condition,keyWord);
        return tableResult;
    }


}