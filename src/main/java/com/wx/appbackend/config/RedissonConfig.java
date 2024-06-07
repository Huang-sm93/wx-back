package com.wx.appbackend.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: sm.huang
 * @Date: 2024/6/7  16:20
 **/
//redisson 配置类
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {

        Config config =new Config();
        //redis地址
        config.useSingleServer().setAddress("redis://47.95.172.206:6379").setPassword("Ming@Yin8023");
        return Redisson.create(config);

    }



}
