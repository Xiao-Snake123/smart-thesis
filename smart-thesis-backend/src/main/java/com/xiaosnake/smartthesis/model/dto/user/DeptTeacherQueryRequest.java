package com.xiaosnake.smartthesis.model.dto.user;

import com.xiaosnake.smartthesis.model.dto.PageRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系部教师查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DeptTeacherQueryRequest extends PageRequest implements Serializable {

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师系部
     */
    private String deptName;

}
