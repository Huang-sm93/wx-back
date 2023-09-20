package com.wx.appbackend.study.day810;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/8/10
 */
public class Demo {
    public static void main(String[] args) {
        Integer a = new Integer(123);
        Integer b = Integer.valueOf(123);
        Integer d = Integer.valueOf(123);
        Integer c = 123;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);
    }
}
