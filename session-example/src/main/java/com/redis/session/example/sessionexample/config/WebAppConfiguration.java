package com.redis.session.example.sessionexample.config;

import com.redis.session.example.sessionexample.intercept.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/5/10
 */
@Configuration
public class WebAppConfiguration implements WebMvcConfigurer {
    @Bean
    SessionInterceptor getSessionInterceptor() {
        return new SessionInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/user/login");
    }
}
