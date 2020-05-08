package com.redis.session.example.sessionexample.controller;

import com.redis.session.example.sessionexample.entity.UserInfo;
import com.redis.session.example.sessionexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<UserInfo> list() {
        return userService.list();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody UserInfo user) {
        return String.valueOf(userService.save(user));
    }
}
