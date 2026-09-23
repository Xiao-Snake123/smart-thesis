package com.xiaosnake.smartthesis.service;

import com.xiaosnake.smartthesis.model.dto.project.ProjectQueryRequest;
import com.xiaosnake.smartthesis.model.entity.Project;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【project(系部)】的数据库操作Service
* @createDate 2024-06-12 10:34:21
*/
public interface ProjectService extends IService<Project> {

    // 获取查询条件
    QueryWrapper<Project> getQueryWrapper(ProjectQueryRequest projectQueryRequest);

}
