package com.wx.appbackend.test;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFun605_1 {

    public static List<Integer> initList;

    public static void main(String[] args) {
        List<List<Integer>> lastList = ReadExcelUtility.getBFLastNumbersAll("1216");
        for (int i = 0; i < lastList.size(); i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (initList.contains(lastList.get(i).get(j))) {
                    count++;
                }
            }
            if (count >= 4) {
                System.out.println("第"+i+ "行"+lastList.get(i)+"命中"+count+"个");
            }
        }
    }

    static {
        initList = new ArrayList<>();
        initList.add(6);
        initList.add(18);
        initList.add(22);
        initList.add(25);
        initList.add(29);
    }
}


