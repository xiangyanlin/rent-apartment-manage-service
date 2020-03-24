package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Questions)实体类
 *
 * @author makejava
 * @since 2020-03-23 22:32:24
 */
@Data
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


}