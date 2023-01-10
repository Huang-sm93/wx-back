package com.wx.appbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class WXAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(WXAppApplication.class, args);
        Object object = context.getBean("testAutowired");
        System.out.println(object.getClass());
    }

}
