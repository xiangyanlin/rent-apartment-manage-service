package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (VistRequest)实体类
 *
 * @author 向延琳
 * @since 2020-04-06 21:46:36
 */
@Data
public class VistRequest implements Serializable {
    private static final long serialVersionUID = 501036519148209019L;
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
    * 楼盘编号
    */
    private Integer estateId;
    /**
    * 备注信息
    */
    private String remark;
    /**
    * 请求时间
    */
    private Date requestTime;
    /**
    * 看房时间
    */
    private Date vistTime;
    /**
    * 请求状态,1已完成,2待确认,3待看房,4已取消
    */
    private String status;



}