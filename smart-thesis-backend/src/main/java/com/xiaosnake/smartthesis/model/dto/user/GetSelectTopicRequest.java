package com.xiaosnake.smartthesis.model.dto.user;

import com.xiaosnake.smartthesis.model.dto.PageRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询最终题目选中时间记录请求
 */
@Data
public class GetSelectTopicRequest implements Serializable {

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
    /**
     * 题目 id
     */
    private Long topicId;

}
