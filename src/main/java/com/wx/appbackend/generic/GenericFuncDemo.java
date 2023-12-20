package com.wx.appbackend.generic;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/11/1
 */
public class GenericFuncDemo {

    // 泛型方法 上限 只接受Number及其子类
    public <T extends Number> T calculate(T t) {
        return t;
    }

}
