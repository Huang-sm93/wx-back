package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CalculateIndexDC {

    public static void main(String[] args) {
        List<List<Integer>> historyList = ReadExcelUtility.getDCLastNumbersAll();
        int[] countR = new int[34];
        for (int index = 0; index < historyList.size(); index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 0; i < 12; i++) {
                countR[currentList.get(i)]++;
            }
        }
        List<CellNumber> cellNumberList = new ArrayList<>();
        for (int i = 1; i < countR.length; i++) {
            cellNumberList.add(new CellNumber(i, countR[i]));
        }
        cellNumberList.sort(CellNumber::compareTo);
        List<Integer> firstNumberList = cellNumberList.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
        List<Integer> selectedList = firstNumberList.subList(0,25);
        System.out.println(selectedList);

        int[] countB = new int[17];
        for (int index = 0; index < historyList.size(); index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 12; i < 14; i++) {
                countB[currentList.get(i)]++;
            }
        }
        List<CellNumber> cellNumberList1 = new ArrayList<>();
        for (int i = 1; i < countB.length; i++) {
            cellNumberList1.add(new CellNumber(i, countB[i]));
        }
        cellNumberList1.sort(CellNumber::compareTo);
        List<Integer> firstNumberList1 = cellNumberList1.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
        List<Integer> selectedList1 = firstNumberList1.subList(0,16);

        System.out.println(selectedList1);


        }


}


