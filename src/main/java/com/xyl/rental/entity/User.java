package com.xyl.rental.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-22 16:50:58
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -95495178821986018L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String password;
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
    * 学历
    */
    private String education;
    /**
    * 1管理员，2租客，3房东
    */
    private String role;
    /**
    * 房源数量
    */
    private Integer houseNum;
    /**
    * 0未认证，1已认证
    */
    private String identify;

}