package com.xyl.rental.entity;

import java.io.Serializable;

/**
 * (Dict)实体类
 *
 * @author xyl
 * @since 2020-04-19 22:26:17
 */
public class Dict implements Serializable {
    private static final long serialVersionUID = 564675776870405398L;
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
    private String dictName;
    /**
    * 字典值
    */
    private String dictValue;
    /**
    * 字典排序号
    */
    private Integer dictSort;
    /**
    * 是否默认值，0不是，1是
    */
    private String isDefault;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

}