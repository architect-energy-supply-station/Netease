package com.redis.session.example.sessionexample.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.redis.session.example.sessionexample.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@Repository
public interface UserRepository extends BaseMapper<UserInfo> {
}
