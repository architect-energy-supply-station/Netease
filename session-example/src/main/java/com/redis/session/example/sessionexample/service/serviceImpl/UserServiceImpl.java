package com.redis.session.example.sessionexample.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.session.example.sessionexample.entity.UserInfo;
import com.redis.session.example.sessionexample.exception.BusinessException;
import com.redis.session.example.sessionexample.repository.UserRepository;
import com.redis.session.example.sessionexample.service.RedisService;
import com.redis.session.example.sessionexample.service.UserService;
import com.redis.session.example.sessionexample.utils.PasswordUtils;
import com.redis.session.example.sessionexample.vo.req.LoginReqVO;
import com.redis.session.example.sessionexample.vo.resp.LoginRespVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, UserInfo> implements UserService {
    @Autowired
    private RedisService redisService;

    @Override
    public LoginRespVO login(LoginReqVO vo) {
        UserInfo userInfo = baseMapper.selectOne(new QueryWrapper<UserInfo>().eq("username", vo.getUsername()));
        //if 逻辑段（3个）
        //判空
        if (userInfo == null) {
            throw new BusinessException(4000201, "用户名密码不匹配");
        }
        //是否禁用
        if (userInfo.getStatus()==2) {
            throw new BusinessException(4000201, "用户已禁用！");
        }
        //密码（？？？）
        if (!PasswordUtils.matches(userInfo.getSalt(), vo.getPassword(), userInfo.getPassword())) {
            throw new BusinessException(4000201, "用户名密码不匹配");
        }


        LoginRespVO loginRespVO = new LoginRespVO
                ();
        loginRespVO.setToken(UUID.randomUUID().toString());
        loginRespVO.setUserId(Integer.toString(userInfo.getId()));
        //把凭证存储到redis ,设置过期时间60分钟
        redisService.set(loginRespVO.getToken(),loginRespVO.getUserId(),60, TimeUnit.MINUTES);
        return loginRespVO;
    }
}
