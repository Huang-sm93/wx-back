package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class Day515 {
    public static void main(String[] args) {
        int[] arr0 = {19,25,30,31,34,7,9};
        int[] arr1 = {1,3,11,14,20,2,11};
        int[] arr2 = {2,8,11,30,33,5,8};
        int[] arr3 = {3,11,19,29,33,3,12};
        int[] arr4 = {8,9,14,25,29,4,6};
        int[] arr5 = {3,17,22,26,28,7,12};
        int[] arr6 = {7,13,16,25,32,9,11};
        int[] arr7 = {10,12,13,24,25,11,12};
        int[] arr8 = {13,21,25,28,32,2,10};
        int[] arr9 = {7,10,13,28,31,5,4};

        Set<Integer> history1 = new HashSet<>();
        Set<Integer> history2 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            history1.add(arr6[i]);
            history1.add(arr1[i]);
            history1.add(arr7[i]);
            history1.add(arr8[i]);
            history1.add(arr5[i]);
        }
        for (int i = 5; i < 7; i++) {
            history2.add(arr2[i]);
            history2.add(arr3[i]);
            history2.add(arr0[i]);
            history2.add(arr1[i]);
        }
        List<Integer> canSelectList1 = new ArrayList<>();
        for (int i = 1; i < 36; i++) {
            if (!history1.contains(i)) {
                canSelectList1.add(i);
            }
        }
        List<Integer> canSelectList2 = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            if (!history2.contains(i)) {
                canSelectList2.add(i);
            }
        }
        System.out.println("剩余:"+canSelectList1.size());
        System.out.println(canSelectList1);

        System.out.println("剩余:"+canSelectList2.size());
        System.out.println(canSelectList2);

    }
}
