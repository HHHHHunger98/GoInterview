package com.wzh.gointerview.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * question update request class, why we need to differentiate update function from edit function
 * update API is designed for Administrator, able to access more data fields, while edit API is designed for users.
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionUpdateRequest implements Serializable {

    /**
     * which question to be updated
     */
    private Long id;

    /**
     * update the question title
     */
    private String title;

    /**
     * update the question content
     */
    private String content;

    /**
     * update the tags
     */
    private List<String> tags;

    /**
     * update the answer to question
     */
    private String answer;

    /**
     * update the creator id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
