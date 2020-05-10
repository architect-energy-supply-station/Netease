package com.redis.session.example.sessionexample.controller;

import com.redis.session.example.sessionexample.entity.UserInfo;
import com.redis.session.example.sessionexample.service.UserService;
import com.redis.session.example.sessionexample.utils.PasswordUtils;
import com.redis.session.example.sessionexample.vo.req.LoginReqVO;
import com.redis.session.example.sessionexample.vo.req.RegisterReqVO;
import com.redis.session.example.sessionexample.vo.resp.LoginRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/4/1
 */
@RestController
@RequestMapping("api")
@Api("")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/registry")
    @ApiOperation("")
    public Boolean registry(@RequestBody RegisterReqVO reqVO) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(reqVO,userInfo);
        String salt= PasswordUtils.getSalt();
        String ecdPwd=PasswordUtils.encode(reqVO.getPassword(),salt);
        userInfo.setSalt(salt);
        userInfo.setPassword(ecdPwd);
        ;
        return userService.save(userInfo);
    }

    @GetMapping("/user/{id}")
    @ApiOperation("")
    public UserInfo getUserInfo(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @PostMapping("/user/login")
    @ApiOperation("")
    public LoginRespVO login(@RequestBody LoginReqVO loginReqVO) {
        return userService.login(loginReqVO);
    }

}
