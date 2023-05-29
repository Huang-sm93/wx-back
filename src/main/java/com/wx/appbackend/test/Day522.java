
package com.wx.appbackend.test;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class Day522 {
    public static void main(String[] args) {
        List<CellInfo> list = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",40);
        for (int i = 5; i < 16; i++) {
            System.out.print("第"+i+"行"+"\t"+list.get(i).values[0]);
            System.out.print("\t"+list.get(i).values[1]);
            System.out.print("\t"+list.get(i).values[2]);
            System.out.print("\t"+list.get(i).values[3]);
            System.out.print("\t"+list.get(i).values[4]);
            System.out.print("\t"+list.get(i).values[5]);
            System.out.print("\t"+list.get(i).values[6]);
            System.out.println("");
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
