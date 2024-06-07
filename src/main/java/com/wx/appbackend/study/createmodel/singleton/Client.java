package com.wx.appbackend.study.createmodel.singleton;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class Client {
    public static void main(String[] args) {
//        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
//        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
//        System.out.println(hungrySingleton1 == hungrySingleton2);
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
