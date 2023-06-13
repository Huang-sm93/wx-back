package com.wx.appbackend.test;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBFEnableNumbers {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<String>> lastList = ReadExcelUtility.getBFRLastNumbers1();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            res.add(i);
        }
            for (int i = 0; i < lastList.size(); i++) {
                int count = 0;
                List<String> current= lastList.get(i);
                List<Integer> currentList = new ArrayList<>();
                for (int j = 0; j < 12; j++) {
                    int number = Integer.parseInt(current.get(j));
                    if (res.contains(number)){
                        res.remove(new Integer(number));
                    }
                    currentList.add(number);
                    if (initListA.contains(number)){
                        count++;
                    }
                }
                System.out.println(current.get(16) + currentList+"位置"+i+"命中："+count);
            }
        System.out.println(res);
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(14);
        initListA.add(31);
        initListA.add(30);
        initListA.add(15);
        initListA.add(18);
        initListA.add(25);


    }
}

