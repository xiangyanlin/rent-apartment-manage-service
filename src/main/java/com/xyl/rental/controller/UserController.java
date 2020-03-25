package com.xyl.rental.controller;

import com.xyl.rental.entity.User;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    /**
     * 登录
     * @param loginUser
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public R Login(User loginUser, HttpServletRequest request){
        User user = userService.queryByUser(loginUser);
        System.out.println(user);
        if(null!=user){
            request.getSession().setAttribute("user", user.getUserName());
            return R.success(user);
        }else {
            return R.failed("用户名或密码错误");
        }

    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    @ResponseBody
    public R register(@RequestBody User user){
        User byName=new User();
        String userName = user.getUserName();
        byName.setUserName(userName);
//        System.out.println(byName);
        if(null==userService.queryByUser(byName)){
            userService.insert(user);
            return R.success(user);
        }else{
            return R.failed("用户名重复");
        }

    }

    /**
     * 分页条件关键字查询
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
                            User queryCondition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.userService.queryByPage(
                currentPage, pageSize,queryCondition, keyWord);
        return tableResult;
    }

}