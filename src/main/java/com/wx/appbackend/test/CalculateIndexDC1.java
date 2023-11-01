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
public class CalculateIndexDC1 {

    public static void main(String[] args) throws Exception {
        List<List<Integer>> historyList = ReadExcelUtility.getDCLastNumbersAll();
        int[] countR = new int[34];
        int indexK = 3;
        int startSize = 10*22*7+indexK;
        int stepSize = 20;
        int startIndex = startSize;
        for (int index = startIndex; index < ((startIndex+stepSize)<historyList.size() ? (startIndex+stepSize) : historyList.size()); index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 0; i < 6; i++) {
                countR[currentList.get(i)]++;
            }
        }
        List<CellNumber> cellNumberList = new ArrayList<>();
        for (int i = 1; i < countR.length; i++) {
            cellNumberList.add(new CellNumber(i  , countR[i]));
        }
        cellNumberList.sort(CellNumber::compareTo);
        List<Integer> firstNumberList = cellNumberList.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
//        List<Integer> selectedList = firstNumberList.subList(firstNumberList.size()-8,firstNumberList.size());
//        List<Integer> selectedList = firstNumberList.subList(0,12);
//        System.out.println(firstNumberList);

        int[] countB = new int[17];
        for (int index = startIndex; index < ((startIndex+stepSize)<historyList.size() ? (startIndex+stepSize) : historyList.size()); index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 6; i < currentList.size(); i++) {
                countB[currentList.get(i)]++;
            }
        }
        List<CellNumber> cellNumberList1 = new ArrayList<>();
        for (int i = 1; i < countB.length; i++) {
            cellNumberList1.add(new CellNumber(i, countB[i]));
        }
        cellNumberList1.sort(CellNumber::compareTo);

        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File(String.format("统计%s.xls" , indexK)));
            ReadExcelUtility.writeFile7(cellNumberList, book, 1);
            ReadExcelUtility.writeFile7(cellNumberList1, book, 2);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }



//        List<Integer> firstNumberList1 = cellNumberList1.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
//
//        List<Integer> selectedList1 = firstNumberList1.subList(0,4);
//
//        System.out.println(selectedList1);


        }


}


