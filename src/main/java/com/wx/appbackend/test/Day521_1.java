
package com.wx.appbackend.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class Day521_1 {
    public static void main(String[] args) {
        List<CellInfo> list = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",40);
        int[] current = list.get(0).values;
        List<Integer> history1 = new ArrayList<>();
        Set<Integer> history2 = new HashSet<>();
        for (int i = 1; i < 7; i++) {
            history2.add(list.get(i).values[6]);
        }
        List<Integer> blueSelectList = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            if (!history2.contains(i)) {
                blueSelectList.add(i);
            }
        }
        int temp[] = new int[34];
        int startIndex = 1;
        int hisSize = 21;
        for (int i = startIndex; i < hisSize; i++) {
            for (int j = 0; j < 6; j++) {
                temp[list.get(i).values[j]]++;
            }
        }
        for (int i = 1; i < 34; i++) {
//            for (int j = 0; j < hisSize-temp[i]; j++) {
                history1.add(i);
//            }
        }
        List<Integer> mySelectList1 = new ArrayList<>();
        int flag = 1;
        Random random = new Random();
        while (flag > 0) {
            List<Integer> history3 = new ArrayList<>(history1);
            List<Integer> history4 = new ArrayList<>(blueSelectList);
            mySelectList1.clear();
            for (int i = 0; i < 6; i++) {
                mySelectList1.add(getRandomNum(history3,random));
            }
            mySelectList1.sort(Comparator.comparingInt(o -> o));
            int blue = getRandomNum(history4,random);
            if (!isRight(mySelectList1)) {
                continue;
            }
            System.out.println("第"+flag+"次");
            int count = 0;
            for (int i = 0; i < 6; i++) {
                if (mySelectList1.get(i) == current[i]) {
                    count++;
                }
            }
            if (count == 5 ) {
                if (blue == current[6]){System.out.println("中奖啦: "+mySelectList1+" "+blue);}
                else {System.out.println("中奖啦: "+mySelectList1+" "+blue);}
            }

            if (count == 6){
                if (blue == current[6]) {
                System.out.println("中奖啦！！！！");
                break;}else {
                    System.out.println("中6+0啦！！！！");
                }

            }
            flag++;
//            if (isRight(mySelectList1)) {
//                if (blue%2 == 0) {
//                    mySelectList1.add(blue);
//                    flag = false;
//                }
//            }


        }



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
        if (list.get(0) % 2 != 0) {
            return false;
        }
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
            if (integer >= 17) {
                count++;
            }
        }
        if (count != 3) {
            return false;
        }

        // 条件三：每一位奇偶
        int[] temp = {0,0,0,0,0,0,0,0,0,0};
        return true;
    }
}
