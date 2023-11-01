package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CalculateIndexBF {

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> historyList = ReadExcelUtility.getBFLastNumbersAll();
        int[] countR = new int[36];
        int indexK = 1;
        int startSize = 5+indexK;
        int stepSize = historyList.size()-1;
        int startIndex = 1;
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
        System.out.println(firstNumberList);

        int[] countB = new int[13];
        for (int index = startIndex; index < startIndex+stepSize; index++) {
            List<Integer> currentList = historyList.get(index);
            for (int i = 5; i < currentList.size(); i++) {
                countB[currentList.get(i)]++;
            }
        }
        List<CellNumber> cellNumberList1 = new ArrayList<>();
        for (int i = 1; i < countB.length; i++) {
            cellNumberList1.add(new CellNumber(i, countB[i]));
        }
        cellNumberList1.sort(CellNumber::compareTo);
        List<Integer> firstNumberList1 = cellNumberList1.stream().map(cellNumber -> cellNumber.number).collect(Collectors.toList());
        System.out.println(firstNumberList1);


        List<Integer> integerList = historyList.get(indexK-1).subList(0,5);
        for (int i = 0; i < cellNumberList.size(); i++) {
            if (integerList.contains(cellNumberList.get(i).number)){
                System.out.println("数字："+cellNumberList.get(i).number+"\t位置："+(i+1));
            }
        }
        List<Integer> integerList1 = historyList.get(indexK-1).subList(5,7);
        System.out.println("================================");
        for (int i = 0; i < cellNumberList1.size(); i++) {
            if (integerList1.contains(cellNumberList1.get(i).number)){
                System.out.println("数字："+cellNumberList1.get(i).number+"\t位置："+(i+1));
            }
        }



        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File(String.format("BF统计%s-20.xls" , indexK)));
            ReadExcelUtility.writeFile7(cellNumberList, book, 1);
            ReadExcelUtility.writeFile7(cellNumberList1, book, 2);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

        }


}


