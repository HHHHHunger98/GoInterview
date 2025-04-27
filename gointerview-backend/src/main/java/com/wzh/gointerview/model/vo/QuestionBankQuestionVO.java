package com.wzh.gointerview.model.vo;

import com.wzh.gointerview.model.entity.QuestionBankQuestion;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * question bank question relation view object class
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Data
public class QuestionBankQuestionVO implements Serializable {

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

    /**
     * created time
     */
    private Date createTime;

    /**
     * last updated time
     */
    private Date updateTime;

    /**
     * View object to entity object
     *
     * @param questionBankQuestionVO
     * @return
     */
    public static QuestionBankQuestion voToObj(QuestionBankQuestionVO questionBankQuestionVO) {
        if (questionBankQuestionVO == null) {
            return null;
        }
        QuestionBankQuestion questionBankQuestion = new QuestionBankQuestion();
        BeanUtils.copyProperties(questionBankQuestionVO, questionBankQuestion);
        return questionBankQuestion;
    }

    /**
     * Entity object to view object
     *
     * @param questionBankQuestion
     * @return
     */
    public static QuestionBankQuestionVO objToVo(QuestionBankQuestion questionBankQuestion) {
        if (questionBankQuestion == null) {
            return null;
        }
        QuestionBankQuestionVO questionBankQuestionVO = new QuestionBankQuestionVO();
        BeanUtils.copyProperties(questionBankQuestion, questionBankQuestionVO);
        return questionBankQuestionVO;
    }
}
