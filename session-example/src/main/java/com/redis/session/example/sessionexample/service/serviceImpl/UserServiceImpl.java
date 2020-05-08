package com.redis.session.example.sessionexample.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.session.example.sessionexample.entity.UserInfo;
import com.redis.session.example.sessionexample.repository.UserRepository;
import com.redis.session.example.sessionexample.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, UserInfo> implements UserService {
}
