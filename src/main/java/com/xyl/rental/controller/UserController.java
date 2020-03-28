package com.xyl.rental.controller;

import com.xyl.rental.entity.User;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author xyl
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
        Map<String,Object> map=new HashMap<String,Object>();
        User user = userService.queryByUser(loginUser);
        //System.out.println(user);
        if(null!=user){
            request.getSession().setAttribute("user", user.getUserName());
            if(user.getRole().equals("1")){
                map.put("currentAuthority","admin");
            }else{
                map.put("currentAuthority","user");
            }
            map.put("currentUser",user.getUserName());
            map.put("status","ok");
        }else {
            map.put("currentAuthority","guest");
            map.put("status","error");
        }
        return R.success(map);
    }

    /**
     * 获取当前登录用户
     * @param userName
     * @return
     */
    @RequestMapping("currentUser")
    @ResponseBody
    public R getCurrentUser(@RequestParam(name = "userName")String userName){
        User condition=new User();
        condition.setUserName(userName);

        Object currentUser = userService.queryByUser(condition);
        return R.success(currentUser);
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("loginOut")
    @ResponseBody
    public R loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return R.success("ok");
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