package com.redis.session.example.sessionexample.intercept;

import com.redis.session.example.sessionexample.exception.BusinessException;
import com.redis.session.example.sessionexample.service.RedisService;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/5/10
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = request.getHeader("sessionId");
        if (StringUtil.isNullOrEmpty(sessionId)) {
            throw new BusinessException(400012, "授权信息为空，请重新登录！");
        } else {
            if (!redisService.hasKey(sessionId)) {
                throw new BusinessException(400012, "授权信息无效，请重新登录！");
            }
        }
        return true;

    }
}
