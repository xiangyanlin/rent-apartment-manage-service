package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色信息表(Role)实体类
 *
 * @author xyl
 * @since 2020-04-30 11:15:52
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -98524066473708230L;
    /**
    * 角色ID
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色权限字符串
    */
    private String roleKey;
    /**
    * 显示顺序
    */
    private Integer roleSort;
    /**
    * 角色状态（0正常 1停用）
    */
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    private String delFlag;
    /**
    * 创建者
    */
    private String createBy;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新者
    */
    private String updateBy;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 备注
    */
    private String remark;

}