package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CalculateIndexDC2 {

    public static void main(String[] args) {
        List<List<Integer>> historyList = ReadExcelUtility.getDCLastNumbersAll();
        int[] countR = new int[34];
        int startSize = 10+19+4;
        int stepSize = 60;
        int startIndex = startSize;
        for (int index = startIndex; index < startIndex + stepSize; index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 0; i < 6; i++) {
                countR[currentList.get(i)]++;
            }
        }
        List<Integer> canSelectList1 = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            for (int j = 0; j < stepSize-countR[i]; j++) {
                canSelectList1.add(i);
            }
        }

        int[] countB = new int[17];
        for (int index = startIndex; index < startIndex + stepSize; index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 6; i < currentList.size(); i++) {
                countB[currentList.get(i)]++;
            }
        }
        List<Integer> canSelectList2 = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            for (int j = 0; j < stepSize-countB[i]; j++) {
                canSelectList2.add(i);
            }
        }

        for (int j = 0; j < 10; j++) {
            List<Integer> result = new ArrayList<>();
            List<Integer> history3 = new ArrayList<>(canSelectList1);
            Random random = new Random();
            for (int i = 1; i < 9; i++) {
                result.add(getRandomNum(history3,random));
            }
            result.sort(Comparator.comparingInt(o -> o));
            System.out.println(result);
        }

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
}


