package com.xyl.rental.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Contract)实体类
 *
 * @author makejava
 * @since 2020-03-15 23:03:42
 */
public class Contract implements Serializable {
    private static final long serialVersionUID = 733016288805519302L;
    /**
    * 合约编号
    */
    private Integer id;
    /**
    * 合约状态
    */
    private String status;
    /**
    * 物业地址
    */
    private String address;
    /**
    * 房源编号
    */
    private Integer houseId;
    /**
    * 业主姓名
    */
    private String ownerName;
    /**
    * 租客姓名
    */
    private String tenantName;
    /**
    * 签约日期
    */
    private Date startTime;
    /**
    * 到期日期
    */
    private Date endTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}