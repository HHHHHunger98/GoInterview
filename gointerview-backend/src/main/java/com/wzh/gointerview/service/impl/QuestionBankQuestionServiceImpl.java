package com.wzh.gointerview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzh.gointerview.common.ErrorCode;
import com.wzh.gointerview.constant.CommonConstant;
import com.wzh.gointerview.exception.BusinessException;
import com.wzh.gointerview.exception.ThrowUtils;
import com.wzh.gointerview.mapper.QuestionBankQuestionMapper;
import com.wzh.gointerview.model.dto.questionbankquestion.QuestionBankQuestionQueryRequest;
import com.wzh.gointerview.model.entity.QuestionBankQuestion;
import com.wzh.gointerview.model.vo.QuestionBankQuestionVO;
import com.wzh.gointerview.service.QuestionBankQuestionService;
import com.wzh.gointerview.service.UserService;
import com.wzh.gointerview.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * QuestionBankQuestion Bank QuestionBankQuestion Service API Implementation
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Service
@Slf4j
public class QuestionBankQuestionServiceImpl extends ServiceImpl<QuestionBankQuestionMapper, QuestionBankQuestion> implements QuestionBankQuestionService {

    @Override
    public void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add) {
        if (questionBankQuestion == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = questionBankQuestion.getId();
        Long questionBankId = questionBankQuestion.getQuestionBankId();
        Long questionId = questionBankQuestion.getQuestionId();
        Long userId = questionBankQuestion.getUserId();

        // Parameters should not be blank
        if (add) {
            ThrowUtils.throwIf(ObjectUtils.allNotNull(id, questionBankId, questionId, userId), ErrorCode.PARAMS_ERROR);
        }
    }

    /**
     * Generate QueryWrapper for query using mybatis
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest) {
        QueryWrapper<QuestionBankQuestion> queryWrapper = new QueryWrapper<>();
        if (questionBankQuestionQueryRequest == null) {
            return queryWrapper;
        }
        String sortField = questionBankQuestionQueryRequest.getSortField();
        String sortOrder = questionBankQuestionQueryRequest.getSortOrder();
        Long id = questionBankQuestionQueryRequest.getId();
        Long userId = questionBankQuestionQueryRequest.getUserId();
        Long notId = questionBankQuestionQueryRequest.getNotId();
        Long questionBankId = questionBankQuestionQueryRequest.getQuestionBankId();
        Long questionId = questionBankQuestionQueryRequest.getQuestionId();
        // Concatenate the query condition
        queryWrapper.ne(ObjectUtils.isNotEmpty(notId), "id", notId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(questionBankId), "questionBankId", questionBankId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(questionId), "questionId", questionId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request) {
        QuestionBankQuestionVO questionBankQuestionVO = QuestionBankQuestionVO.objToVo(questionBankQuestion);
        return questionBankQuestionVO;
    }

    @Override
    public Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request) {
        List<QuestionBankQuestion> questionBankQuestionList = questionBankQuestionPage.getRecords();
        Page<QuestionBankQuestionVO> questionBankQuestionVOPage = new Page<>(questionBankQuestionPage.getCurrent(), questionBankQuestionPage.getSize(), questionBankQuestionPage.getTotal());
        if (CollectionUtils.isEmpty(questionBankQuestionList)) {
            return questionBankQuestionVOPage;
        }
        List<QuestionBankQuestionVO> questionBankQuestionVOList = questionBankQuestionList.stream().map(questionBankQuestion -> {
            QuestionBankQuestionVO questionBankQuestionVO = QuestionBankQuestionVO.objToVo(questionBankQuestion);
            return questionBankQuestionVO;
        }).collect(Collectors.toList());
        questionBankQuestionVOPage.setRecords(questionBankQuestionVOList);
        return questionBankQuestionVOPage;
    }
}




