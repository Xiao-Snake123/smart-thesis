package com.xiaosnake.smartthesis.model.dto.schedule;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 设置选题开放时间
 */
@Data
public class UnSetTimeRequest implements Serializable {

    /**
     * 选题列表
     */
    List<Long> topicIds;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
