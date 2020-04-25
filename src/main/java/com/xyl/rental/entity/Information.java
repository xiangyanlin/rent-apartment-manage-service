package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Information)实体类
 *
 * @author xyl
 * @since 2020-04-25 23:10:12
 */
@Data
public class Information implements Serializable {
    private static final long serialVersionUID = 813078478287995890L;
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