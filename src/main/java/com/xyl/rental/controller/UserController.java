package com.xyl.rental.controller;

import com.xyl.rental.entity.User;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.Date;
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
        if(null!=loginUser.getUserName()&&null!=loginUser.getPassword()){
            User user = userService.queryByUser(loginUser);
            //System.out.println(user);
            if(null!=user){
                //request.getSession().setAttribute("user", user.getUserName());
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
        }else{
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
        //System.out.println(userName);
        if(null!=userName&&userName.length()>0){
            User condition=new User();
            condition.setUserName(userName);

            Object currentUser = userService.queryByUser(condition);
            if(null!=currentUser){
                return R.success(currentUser);
            }else{
                return  R.failed("null");
            }
        }else{
            return  R.failed("userName为空");
        }


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
        user.setRole("2");
        User insert = userService.insert(user);
        return R.success(insert);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("update")
    public R updateHouseResources(@RequestBody User user) {
        //System.out.println(user);
        User update = userService.update(user);
        return R.success(update);
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