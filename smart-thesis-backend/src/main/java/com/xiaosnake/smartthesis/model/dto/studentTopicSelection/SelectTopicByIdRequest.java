package com.xiaosnake.smartthesis.model.dto.studentTopicSelection;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求添加选题体
 */
@Data
public class SelectTopicByIdRequest implements Serializable {

    /**
     * 题目 id
     */
    private Long id;

    /**
     * 1-表示选题, 0-表示退选
     */
    private int status;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}