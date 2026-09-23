package com.xiaosnake.smartthesis.model.vo;

import lombok.Data;

/**
 * 题目选锁返回视图
 */
@Data
public class TopicLockVO {

    /**
     * 是否锁住
     */
    Boolean islock;

    /**
     * 锁住时间
     */
    String lockTime;

}
