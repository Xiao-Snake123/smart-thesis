package com.xiaosnake.smartthesis.manager.redis;

import cn.dev33.satoken.SaManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Redis 配置类
 */
@Component
@Data
@Slf4j
public class RedisConfig {

    /**
     * 键位前缀
     */
    private String keyPrefix = "smart-thesis:";

    /**
     * 打印配置
     */
    @PostConstruct
    public void printConfig() {
        log.debug("[RedisConfig] keyPrefix: {}", this.keyPrefix);
    }

}
