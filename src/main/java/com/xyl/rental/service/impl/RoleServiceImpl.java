package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Role;
import com.xyl.rental.dao.RoleDao;
import com.xyl.rental.service.RoleService;
import com.xyl.rental.utils.PageUtils;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author xyl
 * @since 2020-04-30 11:15:52
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return this.roleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }

    /**
     * 角色列表
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize, Role condition, String keyWord) {
        int start=(currentPage-1)*pageSize;
        int total=roleDao.countTotal(condition,keyWord);
        List<Role> list = roleDao.queryPage(
                start, pageSize,condition,keyWord);
        return PageUtils.page(start,total,list,currentPage,pageSize);
    }
}