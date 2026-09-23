package com.xiaosnake.smartthesis.model.dto.dept;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 */
@Data
public class DeleteDeptRequest implements Serializable {

    /**
     * id
     */
    private String deptName;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}