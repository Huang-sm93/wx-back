package com.wx.appbackend.createmodel.factory;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class BookA implements Book {
    @Override
    public void show() {
        System.out.println("生产BookA");
    }
}
