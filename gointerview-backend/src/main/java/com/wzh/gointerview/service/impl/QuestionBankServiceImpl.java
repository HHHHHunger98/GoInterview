package com.wzh.gointerview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.wzh.gointerview.common.ErrorCode;
import com.wzh.gointerview.constant.CommonConstant;
import com.wzh.gointerview.exception.BusinessException;
import com.wzh.gointerview.exception.ThrowUtils;
import com.wzh.gointerview.mapper.QuestionBankMapper;
import com.wzh.gointerview.model.dto.questionbank.QuestionBankQueryRequest;
import com.wzh.gointerview.model.entity.QuestionBank;
import com.wzh.gointerview.model.entity.User;
import com.wzh.gointerview.model.vo.QuestionBankVO;
import com.wzh.gointerview.model.vo.UserVO;
import com.wzh.gointerview.service.QuestionBankService;
import com.wzh.gointerview.service.UserService;
import com.wzh.gointerview.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Question Bank Service API Implementation
 *
 * @author <a href="https://github.com/hhhhhunger98">wzh</a>
 */
@Service
@Slf4j
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements QuestionBankService {

    private final static Gson GSON = new Gson();

    @Resource
    private UserService userService;

    @Override
    public void validQuestionBank(QuestionBank questionBank, boolean add) {
        if (questionBank == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String title = questionBank.getTitle();
        String description = questionBank.getDescription();
        String picture = questionBank.getPicture();

        // Parameters should not be blank
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(title,description,picture), ErrorCode.PARAMS_ERROR);
        }
        // Check parameters validation
        if (StringUtils.isNotBlank(title) && title.length() > 80) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "The title length should be less than 80 characters");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "The description length should be less than 8192 characters");
        }
        if (StringUtils.isNotBlank(picture) && description.length() > 2048) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "The picture url length should be less than 2048 characters");
        }
    }

    /**
     * 获取查询包装类
     *
     * @param questionBankQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<QuestionBank> getQueryWrapper(QuestionBankQueryRequest questionBankQueryRequest) {
        QueryWrapper<QuestionBank> queryWrapper = new QueryWrapper<>();
        if (questionBankQueryRequest == null) {
            return queryWrapper;
        }
        String searchText = questionBankQueryRequest.getSearchText();
        String sortField = questionBankQueryRequest.getSortField();
        String sortOrder = questionBankQueryRequest.getSortOrder();
        Long id = questionBankQueryRequest.getId();
        String title = questionBankQueryRequest.getTitle();
        String description = questionBankQueryRequest.getDescription();
        Long userId = questionBankQueryRequest.getUserId();
        Long notId = questionBankQueryRequest.getNotId();
        // Concatenate the query condition
        if (StringUtils.isNotBlank(searchText)) {
            queryWrapper.like("title", searchText).or().like("description", searchText);
        }
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);
        queryWrapper.like(StringUtils.isNotBlank(description), "content", description);
        queryWrapper.ne(ObjectUtils.isNotEmpty(notId), "id", notId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public QuestionBankVO getQuestionBankVO(QuestionBank questionBank, HttpServletRequest request) {
        QuestionBankVO questionBankVO = QuestionBankVO.objToVo(questionBank);
        long questionBankId = questionBank.getId();
        // Join query for user information
        Long userId = questionBank.getUserId();
        User user = null;
        if (userId != null && userId > 0) {
            user = userService.getById(userId);
        }
        UserVO userVO = userService.getUserVO(user);
        questionBankVO.setUser(userVO);

        return questionBankVO;
    }

    @Override
    public Page<QuestionBankVO> getQuestionBankVOPage(Page<QuestionBank> questionBankPage, HttpServletRequest request) {
        List<QuestionBank> questionBankList = questionBankPage.getRecords();
        Page<QuestionBankVO> questionBankVOPage = new Page<>(questionBankPage.getCurrent(), questionBankPage.getSize(), questionBankPage.getTotal());
        if (CollectionUtils.isEmpty(questionBankList)) {
            return questionBankVOPage;
        }
        // Join query for user information
        Set<Long> userIdSet = questionBankList.stream().map(QuestionBank::getUserId).collect(Collectors.toSet());
        Map<Long, List<User>> userIdUserListMap = userService.listByIds(userIdSet).stream()
                .collect(Collectors.groupingBy(User::getId));
        // Additional information
        List<QuestionBankVO> questionBankVOList = questionBankList.stream().map(questionBank -> {
            QuestionBankVO questionBankVO = QuestionBankVO.objToVo(questionBank);
            Long userId = questionBank.getUserId();
            User user = null;
            if (userIdUserListMap.containsKey(userId)) {
                user = userIdUserListMap.get(userId).get(0);
            }
            questionBankVO.setUser(userService.getUserVO(user));
            return questionBankVO;
        }).collect(Collectors.toList());
        questionBankVOPage.setRecords(questionBankVOList);
        return questionBankVOPage;
    }

}




