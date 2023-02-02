package com.wx.appbackend.study.reflection;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/2/1
 */
public class ReflectionDemo {
    private String name;
    public int anInt;

    public ReflectionDemo() {
    }

    private ReflectionDemo(String studentName) {
        this.name = studentName;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    private String show(String message) {
        System.out.println("show: " + name + "," + anInt + "," + message);
        return "testReturnValue";
    }
}
