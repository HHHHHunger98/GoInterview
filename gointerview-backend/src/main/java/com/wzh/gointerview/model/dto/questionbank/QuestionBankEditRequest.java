package com.wzh.gointerview.model.dto.questionbank;

import lombok.Data;

import java.io.Serializable;

/**
 * Question bank edit request class
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionBankEditRequest implements Serializable {

    /**
     * which question to be edited
     */
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

    private static final long serialVersionUID = 1L;
}
