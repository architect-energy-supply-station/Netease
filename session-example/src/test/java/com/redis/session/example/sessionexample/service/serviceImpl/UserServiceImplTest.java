package com.redis.session.example.sessionexample.service.serviceImpl;

import com.redis.session.example.sessionexample.exception.BusinessException;
import com.redis.session.example.sessionexample.vo.req.LoginReqVO;
import com.redis.session.example.sessionexample.vo.resp.LoginRespVO;
import io.swagger.annotations.ApiOperation;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    private LoginReqVO loginReqVO;
@Test
    void LoginSuccessful() {
        // 用例四正常注册
        loginReqVO = new LoginReqVO();
        loginReqVO.setUsername("cindy");
        loginReqVO.setPassword("demoData1");
        assertNotNull(userService.login(loginReqVO));
    }
    @Test
    void TestUsernameDoesNotExist() {
        //用例一：username查询，userInfo为空
        loginReqVO = new LoginReqVO();
        loginReqVO.setUsername("");
        loginReqVO.setPassword("demoData");
       assertThrows(BusinessException.class,()->userService.login(loginReqVO),"The expectation is that the login was successful, but it did not log in successfully") ;
    }

@Test
    void TestThePasswordIsIncorrect() {
        //    用例三：密码不正确
        loginReqVO = new LoginReqVO();
        loginReqVO.setUsername("cindy");
        loginReqVO.setPassword("demoData");
        assertThrows(BusinessException.class,()->userService.login(loginReqVO),"The expectation is that the login was successful, but it did not log in successfully") ;
    }
    @Test
    void TestUserDeactivated() {
        //    用例二：状态码为2,
        loginReqVO = new LoginReqVO();
        loginReqVO.setUsername("bill");
        loginReqVO.setPassword("demoData");
        assertThrows(BusinessException.class,()->userService.login(loginReqVO),"The expectation is that the login was successful, but it did not log in successfully") ;
    }
}