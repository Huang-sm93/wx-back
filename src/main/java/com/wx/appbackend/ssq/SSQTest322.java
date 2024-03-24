package com.wx.appbackend.ssq;

import com.wx.appbackend.test.ReadExcelUtility;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class SSQTest322 {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0321";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/ssq/ssq%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        int startIndex = 0;
        int stepSize = 3;
        int maxCount = 10;
        for (int i = startIndex; i < maxCount; i++) {
            List<Integer> curList = lastList.get(i).subList(0, 6);
            List<Integer> remCurList = lastList.get(i+1).subList(0, 6);
            for (int j = i+1; j < i+100; j++) {
                Set<Integer> canSelectList = new HashSet<>();
                for (int k = 0; k < stepSize; k++) {
                    canSelectList.addAll(lastList.get(j+k).subList(0, 6));
                }
                int count = (int) curList.stream().filter(canSelectList::contains).count();
                if (count >= 4) {
                    System.out.println("count = " + count + "\t\t" +
                            "curList = " + curList + "\t\t" +
                            "当前位置 = " + i + "\t\t" +
                            "相对位置 = " + (j-i) + "\t\t" +
                            "长度 = " + canSelectList.size() + "\t\t" +
                            "canSelectList = " + canSelectList);
                }
            }
            System.out.println("=========================");
        }
    }

    private static final List<List<Integer>> myList = new ArrayList<>();

    static {
        myList.add(Arrays.asList(2,13,19,24,21,22, 3));
        myList.add(Arrays.asList(5,9,18,26,27,29, 3));
        myList.add(Arrays.asList(4,9,13,14,25,32, 3));
        myList.add(Arrays.asList(3,9,12,22,23,31, 3));
        myList.add(Arrays.asList(3,8,13,19,24,28, 3));
    }
}



