package com.wx.appbackend.generic;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/11/1
 * Time:  10:58
 * describe: 泛型类
 */
public class GenericClassDemo<T> {
    private T key;

    public GenericClassDemo(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
