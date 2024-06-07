package com.wx.appbackend.study.proxy;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/15
 */
public class Man implements Person{
    @Override
    public void showSex() {
        System.out.println("Man");
    }
}
