package com.wx.appbackend.study.strategy;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/17
 */
public class Calculate {
    private Strategy strategy;

    public Calculate(Strategy strategy){
        this.strategy = strategy;
    }

    public int calculate(int i1, int i2){
        return strategy.calculate(i1, i2);
    }
}
