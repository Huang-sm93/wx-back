package com.wx.appbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.wx.appbackend.*.dao")
@ConfigurationPropertiesScan("com.wx.appbackend.config")
public class WXAppApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WXAppApplication.class, args);
    }

}
