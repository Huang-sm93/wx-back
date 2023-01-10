package com.wx.appbackend.common;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Object o = null;
//        String s = String.valueOf(o);
//        System.out.println(Double.parseDouble(o == null ? "0" : String.valueOf(o)));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        for (int i = 0; i < list.size(); i++) {
            if (2 == list.get(i)){
                list.remove(list.get(i));
            }
            if (4 == list.get(i)){
                list.remove(list.get(i));
            }
            if (6 == list.get(i)){
                list.remove(list.get(i));
            }
        }
        list.size();
    }
}
