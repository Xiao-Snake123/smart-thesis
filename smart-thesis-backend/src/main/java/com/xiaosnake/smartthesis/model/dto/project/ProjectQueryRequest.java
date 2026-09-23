package com.xiaosnake.smartthesis.model.dto.project;

import com.xiaosnake.smartthesis.model.dto.PageRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目查询请求
 */
@Data
public class ProjectQueryRequest extends PageRequest implements Serializable {

    private String projectName;

    private String deptName;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
