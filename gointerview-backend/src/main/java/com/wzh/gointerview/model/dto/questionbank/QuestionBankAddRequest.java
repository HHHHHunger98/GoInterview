package com.wzh.gointerview.model.dto.questionbank;

import lombok.Data;

import java.io.Serializable;

/**
 * Add new question bank to question bank table
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionBankAddRequest implements Serializable {

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

    private static final long serialVersionUID = 1L;
}
