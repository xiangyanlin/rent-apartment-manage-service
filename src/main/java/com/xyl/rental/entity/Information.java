package com.xyl.rental.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Information)实体类
 *
 * @author makejava
 * @since 2020-03-15 23:10:02
 */
public class Information implements Serializable {
    private static final long serialVersionUID = -25212641269598104L;
    /**
    * 资讯编号
    */
    private Integer id;
    /**
    * 资讯标题
    */
    private String title;
    /**
    * 资讯内容
    */
    private String content;
    /**
    * 阅读量
    */
    private Integer readNum;
    /**
    * 发布时间
    */
    private Date publishTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

}