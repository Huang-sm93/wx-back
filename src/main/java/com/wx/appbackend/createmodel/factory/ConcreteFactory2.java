package com.wx.appbackend.createmodel.factory;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Phone getPhone() {
        return new PhoneB();
    }

    @Override
    public Book getBook() {
        return new BookB();
    }
}
