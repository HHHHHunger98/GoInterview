package com.wzh.gointerview.model.vo;

import cn.hutool.json.JSONUtil;
import com.wzh.gointerview.model.entity.Question;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * question view object class
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Data
public class QuestionVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * question title
     */
    private String title;

    /**
     * question content
     */
    private String content;

    /**
     * question answer
     */
    private String answer;

    /**
     * creator id
     */
    private Long userId;

    /**
     * created timme
     */
    private Date createTime;

    /**
     * last update time
     */
    private Date updateTime;

    /**
     * Tags list
     */
    private List<String> tagList;

    /**
     * creator view object
     */
    private UserVO user;

    /**
     * View object to entity object
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTagList();
        if (tagList != null) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        return question;
    }

    /**
     * Entity object to view object
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        questionVO.setTagList(JSONUtil.toList(question.getTags(), String.class));
        return questionVO;
    }
}

