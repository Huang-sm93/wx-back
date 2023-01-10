package com.wx.appbackend.user.service;

import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/8/19
 */
@Service
public class TestAutowired {

//    private final UserDao userDao;

    private final UserServiceImpl2 userServiceImpl2;

    public TestAutowired(UserServiceImpl2 userServiceImpl2){
        this.userServiceImpl2 = userServiceImpl2;
    }

//    public TestAutowired(UserDao userDao){
//        this.userDao = userDao;
//    }
}
