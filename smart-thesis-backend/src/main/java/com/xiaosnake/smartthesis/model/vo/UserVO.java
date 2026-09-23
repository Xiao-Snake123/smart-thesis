package com.xiaosnake.smartthesis.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户脱敏类
 */
@Data
public class UserVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar = "/logo_128.png";

    /**
     * 用户角色：user/admin/ban
     */
    private Integer userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private String status;

}
