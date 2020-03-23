package com.xyl.rental.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Questions)实体类
 *
 * @author makejava
 * @since 2020-03-23 22:32:24
 */
public class Questions implements Serializable {
    private static final long serialVersionUID = -11657474566461866L;
    /**
    * 问答编号
    */
    private Integer id;
    /**
    * 问答标题
    */
    private String title;
    /**
    * 问答内容
    */
    private String content;
    /**
    * 发布者
    */
    private String publisher;
    /**
    * 阅读量
    */
    private Integer readNum;
    /**
    * 回复量
    */
    private Integer replyNum;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

}