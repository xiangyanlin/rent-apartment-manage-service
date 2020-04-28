package com.xyl.rental.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Questions)实体类
 *
 * @author xyl
 * @since 2020-04-28 23:16:00
 */
@Data
public class Questions implements Serializable {
    private static final long serialVersionUID = -13257877529066567L;
    /**
    * 问答编号
    */
    private Integer id;
    /**
    * 问题
    */
    private String questions;
    /**
    * 问题描述
    */
    private String summary;
    /**
    * 回答
    */
    private String answer;
    /**
    * 提问者编号
    */
    private Integer questionerId;
    /**
    * 回答者编号
    */
    private Integer answererId;
    /**
    * 问题状态
    */
    private String status;
    /**
    * 提问时间
    */
    private Date quizTime;
    /**
    * 回答时间
    */
    private Date answerTime;



}