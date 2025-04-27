package com.wzh.gointerview.model.dto.questionbank;

import com.wzh.gointerview.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Query question bank request class
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionBankQueryRequest extends PageRequest implements Serializable {

    /**
     * query by question bank id
     */
    private Long id;

    /**
     * query by question bank title
     */
    private String title;

    /**
     * query by the question bank description
     */
    private String description;

    /**
     * query by the question bank picture
     */
    private String picture;

    /**
     * query by the creator id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
