package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (VistRequest)实体类
 *
 * @author xyl
 * @since 2020-04-19 20:37:56
 */
@Data
public class VistRequest implements Serializable {
    private static final long serialVersionUID = 186257770572694513L;
    /**
    * 请求编号
    */
    private Integer id;
    /**
    * 租客编号
    */
    private Integer tenantId;
    /**
    * 房东编号
    */
    private Integer ownerId;
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
    * 请求状态,1已完成,2待确认,3待看房,4已取消,5已拒绝
    */
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}