package com.wzh.gointerview.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzh.gointerview.model.dto.questionbankquestion.QuestionBankQuestionQueryRequest;
import com.wzh.gointerview.model.entity.QuestionBankQuestion;
import com.wzh.gointerview.model.vo.QuestionBankQuestionVO;

import javax.servlet.http.HttpServletRequest;

public interface QuestionBankQuestionService extends IService<QuestionBankQuestion> {

    /**
     * validation
     *
     * @param questionBankQuestion
     * @param add
     */
    void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add);

    /**
     * query on table question bank question
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);

    /**
     * query from elastic search
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    //Page<QuestionBankQuestion> searchFromEs(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);

    /**
     * get question bank view object class
     *
     * @param questionBankQuestion
     * @param request
     * @return
     */
    QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request);

    /**
     * get questionBankQuestion view objects by pages
     *
     * @param questionBankQuestionPage
     * @param request
     * @return
     */
    Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request);
}
