package com.wx.appbackend.test;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/8
 */
public class Test111 {
    public static void main(String[] args) {
        List<Integer> history = new ArrayList<>();
        history.add(8);
        history.add(9);
        history.add(14);
        history.add(25);
        history.add(29);
        int[] arr1 = {3,17,22,26,28};
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            res.add(i);
        }
        for (int i = 0; i < arr1.length; i++) {
            res.remove((Integer)arr1[i]);
        }
        List<Integer> outList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int index = (int)(Math.random()*res.size());
            outList.add(res.get(index));
            res.remove(index);
        }

        int countRed = 0;
        for (int i = 0; i < outList.size(); i++) {
            countRed = countRed + (history.contains(outList.get(i)) ? 1 :0);
        }
        System.out.println(countRed);
    }
}
