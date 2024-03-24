package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFun927 {

    public static List<Integer> initList;

    public static void main(String[] args) {
        String indexName = "0315";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/bfun/bf%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (int index = 0; index < lastList.size(); index++) {
            List<Integer> last = lastList.get(index).subList(0,5);
            System.out.println("======================第" + index + "行======================");
            for (int i = 0; i < lastList.size(); i++) {
                if (i == index) {
                    continue;
                }
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (last.contains(lastList.get(i).get(j))) {
                        count++;
                    }
                }
                if (count >= 4) {
                    System.out.println("第"+i+ "行"+lastList.get(i)+"命中"+count+"个");
                }
            }
            System.out.println("============================================================");
        }

    }

    static {
        initList = new ArrayList<>();
        initList.add(3);
        initList.add(12);
        initList.add(15);
        initList.add(28);
        initList.add(35);
    }
}


