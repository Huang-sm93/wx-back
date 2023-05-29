
package com.wx.appbackend.test;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class Day521 {
    public static void main(String[] args) {
        List<CellInfo> list = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\近30次历史记录.xls",40);
        List<Integer> history1 = new ArrayList<>();
        Set<Integer> history2 = new HashSet<>();

        int temp[] = new int[34];
        int startIndex = 1;
        int hisSize = 5;
        for (int i = startIndex; i < hisSize; i++) {
            for (int j = 0; j < 6; j++) {
                temp[list.get(i).values[j]]++;
            }
        }
        for (int i = 1; i < 34; i++) {
            for (int j = 0; j < hisSize-temp[i]; j++) {
                history1.add(i);
            }
        }

        for (int i = 1; i < 10; i++) {
            history2.add(list.get(i).values[6]);
        }
        List<List<Integer>> canSelectList1 = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            List<Integer> temp1 = new ArrayList<>();
            Random random = new Random();
            for (int i = 1; i < 7; i++) {
                temp1.add(getRandomNum(history1,random));
            }
            temp1.sort(Comparator.comparingInt(o -> o));
            canSelectList1.add(temp1);
        }
        Set<Integer> canSelectList = new HashSet<>();
        for (int i = 0; i < canSelectList1.size(); i++) {
            canSelectList.add(history1.get(i));
        }
        System.out.println("红球可选结果:"+canSelectList);
        List<Integer> canSelectList2 = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            if (!history2.contains(i)) {
                canSelectList2.add(i);
            }
        }
        for (int i = 0; i < canSelectList1.size(); i++) {
            System.out.println("第"+i+"个：" + canSelectList1.get(i));
        }


        System.out.println("篮球可选结果:"+canSelectList2);

    }

    public static int getRandomNum(List<Integer> redCount, Random random){

        int randNum = random.nextInt(redCount.size());
        int count = redCount.get(randNum);
        boolean flag = true;
        while (flag){
            flag = redCount.remove(new Integer(count));
        }
        return count;
    }

    public static boolean isRight(List<Integer> list){
        // 条件一：奇数3个 偶数5个
        int oddCount = 0;
        int evenCount = 0;
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        if (evenCount != 3) {
            return false;
        }
        // 条件二：值大于等于18的个数大于等于5
        int count = 0;
        for (Integer integer : list) {
            if (integer >= 18) {
                count++;
            }
        }
        if (count != 8) {
            return false;
        }

        // 条件三：每一位奇偶
        int[] temp = {0,0,0,0,0,0,0,0,0,0};
        return true;
    }
}
