package com.redis.session.example.sessionexample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.redis.session.example.sessionexample.entity.UserInfo;
import com.redis.session.example.sessionexample.vo.req.LoginReqVO;
import com.redis.session.example.sessionexample.vo.resp.LoginRespVO;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
public interface UserService extends IService<UserInfo> {
    LoginRespVO login(LoginReqVO vo);
}
