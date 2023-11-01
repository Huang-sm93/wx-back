package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CountEveryNumberBF {

    public static void main(String[] args) {
//        int startIndex = 200;
//        int startLen = 4;
//        for (int i = startIndex; i < startIndex+20; i++) {
//
//        }
        calculateFirstNumber(20, 9, 10);

    }
    public static void calculateFirstNumber(int startSize, int stepSize, int length) {
        List<List<Integer>> historyList = ReadExcelUtility.getBFLastNumbersAll();
        int countTrue = 0;
        for (int j = 0; j < length; j++) {
            int[] countR = new int[13];
            int count = 0;
            int b1 = historyList.get(j).get(5);
            int b2 = historyList.get(j).get(6);
            startSize = historyList.get(j+1).get(5)+1;
            stepSize = historyList.get(j+1).get(6)+1;
            int startIndex = j+startSize;
            for (int index = startIndex; index < startIndex+stepSize; index++) {
                List<Integer> currentList = historyList.get(index);
                for (int i = 5; i < currentList.size(); i++) {
                    countR[currentList.get(i)]++;
                }
            }
            List<CellNumber> cellNumberList = new ArrayList<>();
            for (int i = 1; i < countR.length; i++) {
                cellNumberList.add(new CellNumber(i, countR[i]));
            }
            cellNumberList.sort(CellNumber::compareTo);
            List<Integer> firstNumberList = cellNumberList.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
            List<Integer> selectedList = firstNumberList.subList(0,4);

            for (Integer integer : selectedList) {
                if (integer == b1 || integer == b2) {
                    count++;
                }
            }

                System.out.println("位置"+j+"\t"+"["+b1+"," + b2+"]"+"\t"+selectedList+"\t"+count);
                countTrue++;

        }

        System.out.println("countTrue = " + countTrue);

    }
}


