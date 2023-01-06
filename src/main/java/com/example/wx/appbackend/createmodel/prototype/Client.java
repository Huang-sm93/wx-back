package com.example.wx.appbackend.createmodel.prototype;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoType protoType1 = new ProtoType();
        protoType1.setName("Java");
        protoType1.setCat(new Cat("小胡"));
        ProtoType protoType2 = (ProtoType) protoType1.clone();
        System.out.println(protoType2.getName());
        protoType1.setName("Python");
        ProtoType protoType3 = (ProtoType) protoType1.clone();
        System.out.println(protoType2.getName());
        System.out.println(protoType3.getName());
    }
}
