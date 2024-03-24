package com.wx.appbackend.study.jvm;

public class VirtualStackDemo {
    public static void main(String[] args) {
        method1();
    }

    public static void method1(){
        int i1 = 1;
        method2(i1);
    }

    public static void method2(int a){
        int i2 = a;
        method3(i2);
    }

    public static void method3(int a){
        int i3 = a;
    }
}
