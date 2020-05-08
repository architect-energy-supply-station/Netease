package com.redis.session.example.sessionexample.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@Configuration
@MapperScan("com.redis.session.example.sessionexample.repository")
public class mybatisPlusConfig {
}
