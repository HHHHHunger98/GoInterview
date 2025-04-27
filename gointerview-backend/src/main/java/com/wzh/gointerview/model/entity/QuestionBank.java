package com.wzh.gointerview.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * question bank
 * @TableName question_bank
 */
@TableName(value ="question_bank")
@Data
public class QuestionBank implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * question bank title
     */
    private String title;

    /**
     * question bank description
     */
    private String description;

    /**
     * question bank picture
     */
    private String picture;

    /**
     * the creator id
     */
    private Long userId;

    /**
     * last edited time
     */
    private Date editTime;

    /**
     * created time
     */
    private Date createTime;

    /**
     * last updated time
     */
    private Date updateTime;

    /**
     * logical delete
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}