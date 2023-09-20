package com.wx.appbackend.study.strategy;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/17
 */
public class Main {
    public static void main(String[] args) {
        Calculate calculate = new Calculate(new AddStrategy());
        System.out.println(calculate.calculate(1, 2));
        calculate = new Calculate(new SubStrategy());
        System.out.println(calculate.calculate(1, 2));
    }
}
