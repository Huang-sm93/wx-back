package com.wx.appbackend.study.strategy;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/17
 */
public class AddStrategy implements Strategy{
    @Override
    public int calculate(int i1, int i2) {
        return i1 + i2;
    }
}
