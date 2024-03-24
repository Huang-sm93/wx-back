package com.wx.appbackend.study.jvm;

public class StackOverFlowErrorDemo {
    static int count = 0;
    public static void main(String[] args) {
        try {
            method();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    static void method(){
        count++;
        method();
    }

}
