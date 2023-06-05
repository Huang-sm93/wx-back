package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFun602_1 {

    public static void main(String[] args) {
        List<Integer> initList = new ArrayList<>();
        initList.add(4);
        initList.add(11);
        initList.add(18);
        initList.add(25);
        initList.add(32);
        System.out.println(isSame(initList));
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            List<Integer> temp = new ArrayList<>();
            Random random = new Random();
            for (int j = 0; j < 5; j++) {
                temp.add(initList.get(j) -3 + random.nextInt(7));
            }
            resultList.add(temp);
        }

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(isSame(resultList.get(i)));
        }

    }
    public static String isSame(List<Integer> list1) {
        boolean flag = false;
        int index = 0;
        List<List<Integer>> list = ReadExcelUtility.getBFArrFileName1("D:\\Work\\wx-app-backend-master\\BF计算位置结果.xls", 0);
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list1.size(); j++) {
                if (list.get(i).contains(list1.get(j))) {
                    count++;
                }
            }
            if (count == 5) {
                flag = true;
                index = i;
                break;
            }
        }
        if (flag) {
            return list1 + "\t命中坐标："+index;
        } else {
            return list1 + "\t未命中";
        }
    }
}

