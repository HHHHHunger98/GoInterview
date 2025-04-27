package com.wzh.gointerview.model.vo;

import com.wzh.gointerview.model.entity.QuestionBank;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * question bank view object class
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Data
public class QuestionBankVO implements Serializable {

    /**
     * id
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
     * creator view object
     */
    private UserVO user;

    /**
     * View object to entity object
     *
     * @param questionBankVO
     * @return
     */
    public static QuestionBank voToObj(QuestionBankVO questionBankVO) {
        if (questionBankVO == null) {
            return null;
        }
        QuestionBank questionBank = new QuestionBank();
        BeanUtils.copyProperties(questionBankVO, questionBank);
        return questionBank;
    }

    /**
     * Entity object to view object
     *
     * @param questionBank
     * @return
     */
    public static QuestionBankVO objToVo(QuestionBank questionBank) {
        if (questionBank == null) {
            return null;
        }
        QuestionBankVO questionBankVO = new QuestionBankVO();
        BeanUtils.copyProperties(questionBank, questionBankVO);
        return questionBankVO;
    }
}
