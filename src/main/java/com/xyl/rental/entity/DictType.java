package com.xyl.rental.entity;

import java.io.Serializable;

/**
 * (DictType)实体类
 *
 * @author xyl
 * @since 2020-04-19 22:26:35
 */
public class DictType implements Serializable {
    private static final long serialVersionUID = 743389506414629017L;
    /**
    * 字典类型编号
    */
    private Integer id;
    /**
    * 字典类型名
    */
    private String dictTypeName;
    /**
    * 字典类型描述
    */
    private String dictTypeDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictTypeDesc() {
        return dictTypeDesc;
    }

    public void setDictTypeDesc(String dictTypeDesc) {
        this.dictTypeDesc = dictTypeDesc;
    }

}