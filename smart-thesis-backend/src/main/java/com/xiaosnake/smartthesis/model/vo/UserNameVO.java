package com.xiaosnake.smartthesis.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户名字脱敏类
 */
@Data
public class UserNameVO implements Serializable {


    /**
     * 用户名
     */
    private String userName;


    private static final long serialVersionUID = 1L;
}