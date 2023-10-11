package com.wx.appbackend.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/10/11
 */
@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        //设置redis的地址，这里是单机模式
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //设置Redisson存储数据的格式，这里是使用的Json格式
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }
}
