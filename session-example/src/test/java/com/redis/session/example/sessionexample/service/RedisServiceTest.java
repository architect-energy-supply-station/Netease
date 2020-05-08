package com.redis.session.example.sessionexample.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisServer;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RedisServiceTest {

    @Autowired
    RedisService redisService;



    @Test
    void hasKey() {
    }

    @Test
    void delete() {
        redisService.delete("name");
    }

    @Test
    void set() {
        redisService.set("name","bill");
    }
}