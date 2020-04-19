package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Contract)实体类
 *
 * @author xyl
 * @since 2020-03-23 17:02:01
 */
@Data
public class Contract implements Serializable {
    private static final long serialVersionUID = 430561169110793708L;
    /**
    * 合约编号
    */
    private Integer id;
    /**
    * 合约状态1待签约，2履约中，3已结束，4已逾期
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




}