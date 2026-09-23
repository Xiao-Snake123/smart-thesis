package com.xiaosnake.smartthesis.model.dto.user;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户删除请求
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * 账号(因为用户账号本身就是唯一的, 因此完全可以替代 id 值)
     */
    private String userAccount;

    /// 序列化字段 ///
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}