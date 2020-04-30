package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author xyl
 * @since 2020-04-30 13:30:38
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 841883806522098105L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 角色编号
    */
    private Integer roleId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String password;
    /**
    * 头像路径
    */
    private String avatar;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 性别0未知，1男性，2女性
    */
    private String sex;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 身份证号
    */
    private String idCard;
    /**
    * 职业
    */
    private String profession;
    /**
    * 学历1大专以下，2大专，3本科，4研究生，5研究生以上
    */
    private String education;
    /**
    * 房源数量
    */
    private Integer houseNum;
    /**
    * 0未认证，1已认证
    */
    private String identify;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 备注信息
    */
    private String remark;

}