package com.xyl.rental.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 楼盘表(Estate)实体类
 *
 * @author makejava
 * @since 2020-03-05 11:00:21
 */
public class Estate implements Serializable {
    private static final long serialVersionUID = 753600489973224510L;
    
    private Integer id;
    /**
    * 楼盘名称
    */
    private String name;
    /**
    * 所在省
    */
    private String province;
    /**
    * 所在市
    */
    private String city;
    /**
    * 所在区
    */
    private String area;
    /**
    * 具体地址
    */
    private String address;
    /**
    * 建筑年代
    */
    private String year;
    /**
    * 建筑类型
    */
    private String type;
    /**
    * 物业费
    */
    private String propertyCost;
    /**
    * 物业公司
    */
    private String propertyCompany;
    /**
    * 开发商
    */
    private String developers;
    /**
    * 创建时间
    */
    private Date created;
    /**
    * 更新时间
    */
    private Date updated;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyCost() {
        return propertyCost;
    }

    public void setPropertyCost(String propertyCost) {
        this.propertyCost = propertyCost;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}