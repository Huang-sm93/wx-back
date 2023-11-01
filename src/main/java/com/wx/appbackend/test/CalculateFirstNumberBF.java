package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CalculateFirstNumberBF {

    public static void main(String[] args) {
//        int startIndex = 200;
//        int startLen = 4;
//        for (int i = startIndex; i < startIndex+20; i++) {
//
//        }
        calculateFirstNumber(50, 4, 100);

    }
    public static void calculateFirstNumber(int startSize, int stepSize, int length) {
        List<List<Integer>> historyList = ReadExcelUtility.getBFLastNumbersAll();
        int countTrue = 0;
        for (int j = 0; j < length; j++) {
            int[] countR = new int[36];
            int count = 0;
            List<Integer> redList = historyList.get(j).subList(0,5);
            startSize = historyList.get(j+1).get(5)+1;
            stepSize = historyList.get(j+1).get(6)+1;
            int startIndex = j+startSize;
            for (int index = startIndex; index < startIndex+stepSize; index++) {
                List<Integer> currentList = historyList.get(index);
                for (int i = 0; i < 5; i++) {
                    countR[currentList.get(i)]++;
                }
            }
            List<CellNumber> cellNumberList = new ArrayList<>();
            for (int i = 1; i < countR.length; i++) {
                cellNumberList.add(new CellNumber(i, countR[i]));
            }
            cellNumberList.sort(CellNumber::compareTo);
            List<Integer> firstNumberList = cellNumberList.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
            List<Integer> selectedList = firstNumberList.subList(0,15);
//            List<Integer> selectedList = new ArrayList<>();
//            int[] indexNum = {1,2,3,4,5,7};
//            for (int i = 0; i < 6; i++) {
//                selectedList.add(firstNumberList.get(indexNum[i]));
//            }
            for (Integer integer : redList) {
                if (selectedList.contains(integer)) {
                    count++;
                }
            }
            if (count > 1){
                System.out.println("位置"+j+"\t"+redList+"\t"+selectedList+"\t"+count);
                countTrue++;
            }
        }

        System.out.println("countTrue = " + countTrue);

    }

}


