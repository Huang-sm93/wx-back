package com.wx.appbackend.createmodel.prototype;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class Cat implements Cloneable{
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat clone() throws CloneNotSupportedException {
        return (Cat)super.clone();
    }

}
