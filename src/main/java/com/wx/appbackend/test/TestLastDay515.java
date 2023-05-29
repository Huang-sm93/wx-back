package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/15
 */
public class TestLastDay515 {
    public static void main(String[] args) {
        List<int[]> history = ReadExcelUtility.getAllList();
        int currentIndex = 0;
        int redStartIndex = currentIndex+10;
        int redEndIndex = redStartIndex+5;

        int blueStartIndex = currentIndex+20;
        int blueEndIndex = blueStartIndex+10;

        int[] current = history.get(currentIndex);
        List<Integer> redCanSelectList = new ArrayList<>();
        List<Integer> blueCanSelectList = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            redCanSelectList.add(i);
        }

        for (int i = 1; i < 17; i++) {
            blueCanSelectList.add(i);
        }
        for (int i = 0; i <current.length ; i++) {
            System.out.print(current[i]+"\t");
        }
        System.out.println(" ");
        for (int i = redStartIndex; i <= redEndIndex; i++) {
            redCanSelectList.remove(new Integer(history.get(i)[0]));
            redCanSelectList.remove(new Integer(history.get(i)[1]));
            redCanSelectList.remove(new Integer(history.get(i)[2]));
            redCanSelectList.remove(new Integer(history.get(i)[3]));
            redCanSelectList.remove(new Integer(history.get(i)[4]));
            redCanSelectList.remove(new Integer(history.get(i)[5]));
        }
        for (int i = blueStartIndex; i <= blueEndIndex; i++) {
            blueCanSelectList.remove(new Integer(history.get(i)[6]));
        }
        int sameCount = 0;
        for (int i = 0; i < current.length-1; i++) {
            if (redCanSelectList.contains(current[i])){
                sameCount++;
            }
        }
        System.out.println(redCanSelectList);
        System.out.println("可选总数"+redCanSelectList.size()+"\n相同的个数："+sameCount);

        System.out.println(blueCanSelectList);
        System.out.println("可选总数"+blueCanSelectList.size()+"\n相同的个数："+ (blueCanSelectList.contains(current[6])?1:0));
    }
}
