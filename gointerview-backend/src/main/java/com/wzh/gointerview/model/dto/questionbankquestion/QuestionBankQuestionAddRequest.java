package com.wzh.gointerview.model.dto.questionbankquestion;

import java.io.Serializable;

/**
 * Add new record to the relationship table question bank and question
 * @author <a herf="https://github.com/hhhhhunger98">wzh</>
 */
public class QuestionBankQuestionAddRequest implements Serializable {
    /**
     * question bank id
     */
    private Long questionBankId;

    /**
     * question id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}
