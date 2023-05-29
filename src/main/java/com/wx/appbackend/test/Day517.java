package com.wx.appbackend.test;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class Day517 {
    public static void main(String[] args) {
        List<int[]> arrList = new ArrayList<>();
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
        arrList.add(arr0);
        arrList.add(arr1);
        arrList.add(arr2);
        arrList.add(arr3);
        arrList.add(arr4);
        arrList.add(arr5);
        arrList.add(arr6);
        arrList.add(arr7);
        arrList.add(arr8);
        arrList.add(arr9);


        List<Integer> history0 = new ArrayList<>();
        List<Integer> history1 = new ArrayList<>();
        Set<Integer> history2 = new HashSet<>();

        for (int i = 4; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                history0.add(arrList.get(i)[j]);
            }
        }
        for (int i = 1; i < 36; i++) {
            if (!history0.contains(i)) {
                history1.add(i);
            }
        }
//        int hisSize = 9;
//        for (int i = 5; i <= hisSize; i++) {
//            for (int j = 0; j < 5; j++) {
//                temp[arrList.get(i)[j]]++;
//            }
//        }
//        for (int i = 1; i < 36; i++) {
//            for (int j = 0; j < hisSize-temp[i]; j++) {
//                history1.add(i);
//            }
//        }
        for (int i = 5; i < 7; i++) {
            history2.add(arr2[i]);
            history2.add(arr3[i]);
            history2.add(arr4[i]);
            history2.add(arr1[i]);
        }
        List<Integer> canSelectList1 = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            List<Integer> history3 = new ArrayList<>(history1);
            canSelectList1.clear();
            Random random = new Random();
            for (int i = 1; i < 9; i++) {
                canSelectList1.add(getRandomNum(history3,random));
            }
            canSelectList1.sort(Comparator.comparingInt(o -> o));
            if (isRight(canSelectList1)) {
                flag = false;
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

    public static int getRandomNum(List<Integer> blueCount, Random random){

        int randNum = random.nextInt(blueCount.size());
        int count = blueCount.get(randNum);
        boolean flag = true;
        while (flag){
            flag = blueCount.remove(new Integer(count));
        }
        return count;
    }

    public static boolean isRight(List<Integer> list){
        // 条件一：奇数6个 偶数2个
        int evenCount = 0;
        for (Integer integer : list) {
            if (integer % 2 == 1) {
                evenCount++;
            }
        }
        if (evenCount != 6) {
            return false;
        }
        // 条件二：值大于等于18的个数大于等于5
        int count = 0;
        for (Integer integer : list) {
            if (integer >= 18) {
                count++;
            }
        }
        if (count != 6 && count != 7) {
            return false;
        }
        return true;
    }
}
