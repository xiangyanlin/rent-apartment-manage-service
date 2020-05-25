package com.xyl.rental.controller;

import com.xyl.rental.entity.Role;
import com.xyl.rental.service.RoleService;
import com.xyl.rental.utils.R;
import com.xyl.rental.vo.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(Role)表控制层
 *
 * @author xyl
 * @since 2020-04-30 11:15:52
 */
@Api(tags  = "角色操作接口")
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过主键查询单条角色数据")
    @GetMapping("selectOne")
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @ApiOperation(value = "新增角色")
    @RequestMapping("save")
    @ResponseBody
    public R saveRole(@RequestBody Role role) {
        Role insert = roleService.insert(role);
        return R.success(insert);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @ApiOperation(value = "修改角色")
    @RequestMapping("update")
    @ResponseBody
    public R updateRole(@RequestBody Role role) {

        Role update = roleService.update(role);
        return R.success(update);
    }

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除角色")
    @DeleteMapping("delete")
    @ResponseBody
    public R removeRole(@RequestParam("id") int id) {
//        System.err.println(id);
        boolean b = roleService.deleteById(id);
        return R.success(b,"success");
    }

    /**
     * 角色列表
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @ApiOperation(value = "分页查询角色列表", notes="分页条件关键字查询角色列表")
    @GetMapping("list")
    @ResponseBody
    public TableResult list(@RequestParam(name = "currentPage", defaultValue = "1") int currentPage,
                            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                            Role condition, String keyWord){

        // System.out.println(queryCondition);
        TableResult tableResult = this.roleService.queryByPage(
                currentPage, pageSize,condition, keyWord);
        return tableResult;
    }

    /**
     * 获取所有角色
     * @return
     */
    @ApiOperation(value = "获取所有角色")
    @ResponseBody
    @RequestMapping("selectAll")
    public R selectAll(){
        List estates = this.roleService.queryAll(null);
        return R.success(estates);
    }
}