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
public class SSQTest324 {

    public static void main(String[] args) throws WriteException, IOException {

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



