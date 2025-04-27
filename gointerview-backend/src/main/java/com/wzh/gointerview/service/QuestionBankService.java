package com.wzh.gointerview.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzh.gointerview.model.dto.questionbank.QuestionBankQueryRequest;
import com.wzh.gointerview.model.entity.QuestionBank;
import com.wzh.gointerview.model.entity.QuestionBank;
import com.wzh.gointerview.model.vo.QuestionBankVO;

import javax.servlet.http.HttpServletRequest;

public interface QuestionBankService extends IService<QuestionBank> {
    
    /**
     * validation
     *
     * @param questionBank
     * @param add
     */
    void validQuestionBank(QuestionBank questionBank, boolean add);

    /**
     * get question bank query
     *
     * @param questionBankQueryRequest
     * @return
     */
    QueryWrapper<QuestionBank> getQueryWrapper(QuestionBankQueryRequest questionBankQueryRequest);

    /**
     * query from elastic search
     *
     * @param questionBankQueryRequest
     * @return
     */
    Page<QuestionBank> searchFromEs(QuestionBankQueryRequest questionBankQueryRequest);

    /**
     * get question bank view object class
     *
     * @param questionBank
     * @param request
     * @return
     */
    QuestionBankVO getQuestionBankVO(QuestionBank questionBank, HttpServletRequest request);

    /**
     * get questionBank view objects by pages
     *
     * @param questionBankPage
     * @param request
     * @return
     */
    Page<QuestionBankVO> getQuestionBankVOPage(Page<QuestionBank> questionBankPage, HttpServletRequest request);
}
