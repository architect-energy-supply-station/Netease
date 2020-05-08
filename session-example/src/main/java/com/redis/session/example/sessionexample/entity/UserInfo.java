package com.redis.session.example.sessionexample.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@Data
@TableName("userInfo")
public class UserInfo {
    private String username;
    private String password;
    private String sex;
    private String salt;
}
