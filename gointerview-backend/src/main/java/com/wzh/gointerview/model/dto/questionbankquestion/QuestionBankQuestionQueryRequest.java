package com.wzh.gointerview.model.dto.questionbankquestion;

import com.wzh.gointerview.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Query records in table question bank and question
 *
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionBankQuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * query exclude by id
     */
    private Long notId;

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
