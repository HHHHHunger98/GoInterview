package com.wzh.gointerview.model.dto.questionbank;

import lombok.Data;

import java.io.Serializable;

/**
 * question bank update request class, why we need to differentiate update function from edit function
 * update API is designed for Administrator, able to access more data fields, while edit API is designed for users.
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionBankUpdateRequest implements Serializable {

    /**
     * which question bank to be updated
     */
    private Long id;

    /**
     * update the question bank title
     */
    private String title;

    /**
     * update the question bank description
     */
    private String description;

    /**
     * update the question bank picture
     */
    private String picture;

    /**
     * update the creator id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
