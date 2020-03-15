package com.xyl.rental.entity;

import java.io.Serializable;

/**
 * (RentRecord)实体类
 *
 * @author makejava
 * @since 2020-03-15 22:52:32
 */
public class RentRecord implements Serializable {
    private static final long serialVersionUID = -73839788264882610L;
    /**
    * 记录编号
    */
    private Integer id;
    /**
    * 房源名称
    */
    private String houseName;
    /**
    * 房源id
    */
    private Integer houseId;
    /**
    * 租客id
    */
    private Integer tenanId;
    /**
    * 房东id
    */
    private Integer owerId;
    /**
    * 合同id
    */
    private Integer contractId;
    /**
    * 租房状态1，已确认2，待确认3，待付款
    */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getTenanId() {
        return tenanId;
    }

    public void setTenanId(Integer tenanId) {
        this.tenanId = tenanId;
    }

    public Integer getOwerId() {
        return owerId;
    }

    public void setOwerId(Integer owerId) {
        this.owerId = owerId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}