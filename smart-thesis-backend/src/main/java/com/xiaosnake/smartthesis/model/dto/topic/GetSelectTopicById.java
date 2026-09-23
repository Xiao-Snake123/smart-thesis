package com.xiaosnake.smartthesis.model.dto.topic;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 获取选择题
 */
@Data
public class GetSelectTopicById implements Serializable {

    /**
     * 题目id
     */
    private long id;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}