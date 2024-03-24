package com.wx.appbackend.ssq;

import com.wx.appbackend.test.ReadExcelUtility;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class SSQTest323 {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0321";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/ssq/ssq%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        Set<Integer> allSet = new HashSet<>();
        int startIndex = 3;
        for (int i = startIndex; i < 3+startIndex; i++) {
            allSet.addAll(lastList.get(i).subList(0, 6));
        }
        List<Integer> curList = allSet.stream().sorted().collect(Collectors.toList());
        System.out.println("lastList1 = " + lastList.get(0));
        System.out.println("lastList2 = " + lastList.get(1));
        System.out.println("lastList3 = " + lastList.get(2));
        System.out.println("curList = " + curList);
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



