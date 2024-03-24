package com.wx.appbackend.study.jvm;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryDemo {
    static int count = 0;
    public static void main(String[] args) {
        try {
            String s = "hello";
            List<String> list = new ArrayList<>();

            while (true){
                list.add(s);
                s=s+s;
                count++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    static void method(){
        count++;

    }

}
