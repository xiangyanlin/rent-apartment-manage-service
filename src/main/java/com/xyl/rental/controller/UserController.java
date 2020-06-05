package com.xyl.rental.controller;

import com.xyl.rental.entity.Role;
import com.xyl.rental.entity.User;
import com.xyl.rental.service.RoleService;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author xyl
 * @since 2020-03-15 19:55:28
 */
@Api(tags  = "用户操作接口")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条用户数据")
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户")
    @RequestMapping("save")
    @ResponseBody
    public R saveUser(@RequestBody User user) {
        User insert = userService.insert(user);
        return R.success(insert);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping("delete")
    @ResponseBody
    public R removeUser(@RequestParam("id") int id) {
//        System.err.println(id);
        boolean b = userService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息")
    @RequestMapping("update")
    @ResponseBody
    public R updateUser(@RequestBody User user) {

        User update = userService.update(user);
        return R.success(update);
    }

    /**
     * 登录
     * @param loginUser
     * @return
     */
    @ApiOperation(value = "登录")
    @RequestMapping("login")
    @ResponseBody
    public R Login(User loginUser, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        if(null!=loginUser.getUserName()&&null!=loginUser.getPassword()){
            User user = userService.queryByUser(loginUser);
            //System.out.println(user);
            if(null!=user){
                Role role = roleService.queryById(user.getRoleId());
                map.put("currentAuthority",role.getRoleKey());
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
    @ApiOperation(value = "获取当前登录用户")
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
    @ApiOperation(value = "注册")
    @RequestMapping("register")
    @ResponseBody
    public R register(@RequestBody User user){
        user.setRoleId(2);
        User insert = userService.insert(user);
        return R.success(insert);
    }


    /**
     * 分页条件关键字查询
     * @param currentPage
     * @param pageSize
     * @param queryCondition
     * @param keyWord
     * @return
     */
    @ApiOperation(value = "分页查询用户列表", notes="分页条件关键字查询用户列表")
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

    /**
     * 统计用户总数
     * @return
     */
    @ApiOperation(value = "统计用户总数")
    @GetMapping("total")
    @ResponseBody
    public R countUserTotal(){
        int users = userService.countUserTotal();
        return R.success(users);
    }

    /**
     * 按月统计用户数量
     * @return
     */
    @ApiOperation(value = "按月统计用户数量")
    @GetMapping("countByMon")
    @ResponseBody
    public R countUserByMon(String startTime,String endTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse(startTime);
        Date end = simpleDateFormat.parse(endTime);
        List<Map<Object, Object>> maps = userService.countUserByMon(start,end);
        return R.success(maps);
    }

    /**
     * 发送邮箱验证码
     * @param user
     * @param operation
     * @return
     */
    @ApiOperation(value = "发送邮箱验证码")
    @GetMapping("/sendVerification")
    @ResponseBody
    public R<Map<String, Object>> sendVerification(User user,
        @ApiParam("操作") @RequestParam(required = false) String operation) {
        if (user.getEmail() == null){
            return R.failed("用户邮箱为空");
        }
        return userService.sendVerification(user, operation);
    }

    @GetMapping("/updatePWByVerificationCode")
    @ResponseBody
    public R<Map<String, Object>> updatePWByVerificationCode(
            @ApiParam("newPassword") @RequestParam("newPassword") String newPassword,
            @ApiParam("userId") @RequestParam("userId") String userId
    ) {
        return this.userService.updatePWByVerificationCode(userId, newPassword);
    }

    /**
     * 根据用户名和邮箱查询用户
     *
     * @param userName 用户名
     * @param email 邮箱
     * @return 单条数据
     */
    @GetMapping("/queryByUserNameAndEmail")
    @ApiOperation("根据用户名和邮箱查询用户")
    public R<User> queryByUserNameAndEmail(
            @ApiParam("userName") @RequestParam("userName") String userName,
            @ApiParam("email") @RequestParam("email") String email) {
        User condiction = new User();
        condiction.setUserName(userName);
        condiction.setEmail(email);
        final List<User> users = userService.queryAllByCondition(condiction);
        if (users != null && users.size() == 1) {
            return R.success(users.get(0));
        } else {
            return R.failed("没有找到对应信息");
        }
    }

    /**
     * 验证码验证
     * @param code
     * @param operation
     * @return
     */
    @GetMapping("/verificationCheck")
    public R<Map<String, Object>> verificationCheck(String email,String code,
      @ApiParam("操作") @RequestParam(required = false) String operation) {
        return userService.verificationCheck(email,code, operation);
    }
}