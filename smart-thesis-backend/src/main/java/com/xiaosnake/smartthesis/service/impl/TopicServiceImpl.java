package com.xiaosnake.smartthesis.service.impl;

import com.xiaosnake.smartthesis.constant.CommonConstant;
import com.xiaosnake.smartthesis.exception.BusinessException;
import com.xiaosnake.smartthesis.exception.CodeBindMessageEnums;
import com.xiaosnake.smartthesis.mapper.TopicMapper;
import com.xiaosnake.smartthesis.model.dto.topic.TopicQueryByAdminRequest;
import com.xiaosnake.smartthesis.model.dto.topic.TopicQueryRequest;
import com.xiaosnake.smartthesis.model.entity.Topic;
import com.xiaosnake.smartthesis.model.entity.User;
import com.xiaosnake.smartthesis.service.StudentTopicSelectionService;
import com.xiaosnake.smartthesis.service.TopicService;
import com.xiaosnake.smartthesis.service.UserService;
import com.xiaosnake.smartthesis.utils.SqlUtils;
import com.xiaosnake.smartthesis.utils.ThrowUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description 针对表【topic】的数据库操作Service实现
 * @createDate 2024-05-22 14:41:18
 */
@Service
@Transactional
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Resource
    private UserService userService;

    @Resource
    private StudentTopicSelectionService studentTopicSelectionService;

    @Override
    public QueryWrapper<Topic> getQueryWrapper(TopicQueryRequest topicQueryRequest) {
        ThrowUtils.throwIf(topicQueryRequest == null, CodeBindMessageEnums.PARAMS_ERROR, "请求参数为空");
        assert topicQueryRequest != null;

        String sortField = topicQueryRequest.getSortField();
        String sortOrder = topicQueryRequest.getSortOrder();
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        User currentLoginUser = userService.userGetCurrentLoginUser();
        queryWrapper.eq(userService.userIsAdmin(currentLoginUser) || userService.userIsDept(currentLoginUser), "status", topicQueryRequest.getStatus());
        queryWrapper.like(StringUtils.isNotBlank(topicQueryRequest.getTopic()), "topic", topicQueryRequest.getTopic());
        queryWrapper.like(StringUtils.isNotBlank(topicQueryRequest.getType()), "type", topicQueryRequest.getType());
        queryWrapper.eq(StringUtils.isNotBlank(topicQueryRequest.getTeacherName()), "teacherName", topicQueryRequest.getTeacherName());
        queryWrapper.eq(StringUtils.isNotBlank(topicQueryRequest.getDeptName()), "deptName", topicQueryRequest.getDeptName());
        queryWrapper.eq(topicQueryRequest.getStartTime() != null, "startTime", topicQueryRequest.getStartTime());
        queryWrapper.eq(topicQueryRequest.getEndTime() != null, "endTime", topicQueryRequest.getEndTime());
        queryWrapper.orderBy(SqlUtils.validTopicSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Topic> getTopicQueryByAdminWrapper(TopicQueryByAdminRequest topicQueryByAdminRequest) {
        // 检查请求参数是否为空
        if (topicQueryByAdminRequest == null) {
            throw new BusinessException(CodeBindMessageEnums.PARAMS_ERROR, "请求参数为空");
        }

        // 检查用户是否登录
        final User loginUser = userService.userGetCurrentLoginUser();

        // 获取排序字段和排序顺序
        String sortField = topicQueryByAdminRequest.getSortField();
        String sortOrder = topicQueryByAdminRequest.getSortOrder();

        // 创建查询包装器
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(topicQueryByAdminRequest.getTopic()), "topic", topicQueryByAdminRequest.getTopic());
        queryWrapper.like(StringUtils.isNotBlank(topicQueryByAdminRequest.getType()), "type", topicQueryByAdminRequest.getType());
        queryWrapper.eq(StringUtils.isNotBlank(topicQueryByAdminRequest.getTeacherName()), "teacherName", topicQueryByAdminRequest.getTeacherName());
        queryWrapper.eq(StringUtils.isNotBlank(topicQueryByAdminRequest.getDeptName()), "deptName", topicQueryByAdminRequest.getDeptName());
        queryWrapper.eq(topicQueryByAdminRequest.getStartTime() != null, "startTime", topicQueryByAdminRequest.getStartTime());
        queryWrapper.eq(topicQueryByAdminRequest.getEndTime() != null, "endTime", topicQueryByAdminRequest.getEndTime());
        queryWrapper.eq(StringUtils.isNotBlank(loginUser.getDept()), "deptName", loginUser.getDept());
        // 设置查询条件，筛选出剩余问题数量为1的题目·
        queryWrapper.eq("surplusQuantity", 1);
        queryWrapper.orderBy(SqlUtils.validTopicSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }


}


