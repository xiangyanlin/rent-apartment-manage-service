package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Information)实体类
 *
 * @author xyl
 * @since 2020-04-26 21:27:01
 */
@Data
public class Information implements Serializable {
    private static final long serialVersionUID = 471216671341185579L;
    /**
    * 资讯编号
    */
    private Integer id;
    /**
    * 资讯标题
    */
    private String title;
    /**
    * 资讯简介
    */
    private String summary;
    /**
    * 资讯内容
    */
    private String content;
    /**
    * 资讯图片
    */
    private String pic;
    /**
    * 发布人
    */
    private String publisher;
    /**
    * 阅读量
    */
    private Integer readNum;
    /**
    * 发布时间
    */
    private Date publishTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}