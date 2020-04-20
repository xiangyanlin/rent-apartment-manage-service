package com.xyl.rental.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Dict)实体类
 *
 * @author xyl
 * @since 2020-04-20 22:51:35
 */
@Data
public class Dict implements Serializable {
    private static final long serialVersionUID = -17795540293343636L;
    /**
    * 字典编号
    */
    private Integer id;
    /**
    * 字典类型编号
    */
    private Integer dictTypeId;
    /**
    * 字典名
    */
    private String name;
    /**
    * 字典值
    */
    private String value;
    /**
    * 字典排序号
    */
    private Integer sort;
    /**
    * 是否默认值，0不是，1是
    */
    private String isDefault;

}