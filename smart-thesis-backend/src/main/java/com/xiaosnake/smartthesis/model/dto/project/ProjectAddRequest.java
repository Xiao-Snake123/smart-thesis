package com.xiaosnake.smartthesis.model.dto.project;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class ProjectAddRequest implements Serializable {


    /**
     * 专业
     */
    private String projectName;

    private String deptName;

    /**
     * 专业所属选题组，可在后台统一配置。
     */
    private String groupName;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}