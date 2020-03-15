package com.xyl.rental.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (VistRequest)实体类
 *
 * @author makejava
 * @since 2020-03-15 18:56:10
 */
public class VistRequest implements Serializable {
    private static final long serialVersionUID = 981657042279407577L;
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
    * 请求状态
    */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Date getReuestTime() {
        return reuestTime;
    }

    public void setReuestTime(Date reuestTime) {
        this.reuestTime = reuestTime;
    }

    public Date getVistTime() {
        return vistTime;
    }

    public void setVistTime(Date vistTime) {
        this.vistTime = vistTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}