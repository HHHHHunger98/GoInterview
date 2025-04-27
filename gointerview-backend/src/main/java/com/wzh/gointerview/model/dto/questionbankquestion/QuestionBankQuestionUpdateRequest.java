package com.wzh.gointerview.model.dto.questionbankquestion;

import lombok.Data;

import java.io.Serializable;

/**
 * question bank question relationship table update request class, why we need to differentiate update function from edit function
 * update API is designed for Administrator, able to access more data fields, while edit API is designed for users.
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@Data
public class QuestionBankQuestionUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * question bank id
     */
    private Long questionBankId;

    /**
     * question id
     */
    private Long questionId;

    /**
     * creator id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
