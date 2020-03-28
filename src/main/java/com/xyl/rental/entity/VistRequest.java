package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (VistRequest)实体类
 *
 * @author makejava
 * @since 2020-03-28 16:32:41
 */
@Data
public class VistRequest implements Serializable {
    private static final long serialVersionUID = -60375855426825079L;
    /**
    * 请求编号
    */
    private Integer id;
    /**
    * 租客姓名
    */
    private String tenantName;
    /**
    * 租客电话
    */
    private String mobile;
    /**
    * 房源小区名
    */
    private String village;
    /**
    * 请求时间
    */
    private Date reuestTime;
    /**
    * 看房时间
    */
    private Date vistTime;
    /**
    * 请求状态,1已完成,2待确认,3待看房,4已取消
    */
    private String status;




}