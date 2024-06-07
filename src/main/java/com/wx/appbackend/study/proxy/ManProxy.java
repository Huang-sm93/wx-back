package com.wx.appbackend.study.proxy;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/15
 */
public class ManProxy implements Person{
    private Man man;
    @Override
    public void showSex() {
        System.out.println("代理前置输出");
        man = new Man();
        man.showSex();
        System.out.println("代理后置输出");
    }
}
