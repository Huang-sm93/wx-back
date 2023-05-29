package com.wx.appbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.wx.appbackend.*.dao")
public class WXAppApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WXAppApplication.class, args);
    }

}
