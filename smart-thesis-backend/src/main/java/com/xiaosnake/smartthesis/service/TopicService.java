package com.xiaosnake.smartthesis.service;

import com.xiaosnake.smartthesis.model.dto.topic.TopicQueryByAdminRequest;
import com.xiaosnake.smartthesis.model.dto.topic.TopicQueryRequest;
import com.xiaosnake.smartthesis.model.entity.Topic;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【topic】的数据库操作Service
* @createDate 2024-05-22 14:41:18
*/
public interface TopicService extends IService<Topic> {

    // 获取查询条件
    QueryWrapper<Topic> getQueryWrapper(TopicQueryRequest topicQueryRequest);

    // TODO: 廖写的查询条件都有问题...就不应该这么传递参数的, 头疼真的, 我也不敢删除
    QueryWrapper<Topic> getTopicQueryByAdminWrapper(TopicQueryByAdminRequest topicQueryByAdminRequest);

}
