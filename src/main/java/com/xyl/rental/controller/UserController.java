package com.xyl.rental.controller;

import com.xyl.rental.entity.User;
import com.xyl.rental.service.UserService;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-15 19:55:28
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            User queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.userService.queryByPage(
                currentPage, pageSize,queryCondition, keyWord);
        return tableResult;
    }

}