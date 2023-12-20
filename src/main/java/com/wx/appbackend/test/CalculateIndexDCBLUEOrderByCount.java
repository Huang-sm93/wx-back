package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class CalculateIndexDCBLUEOrderByCount {

    public static void main(String[] args) throws WriteException, IOException {
        String date = "1211";
        List<List<Integer>> redList = ReadExcelUtility.getDCLastNumbersBlue(date);
        List<List<CountNumber>> cellNumberListList = new ArrayList<>();
        for (int k = 1; k <31; k++) {
            int[] countR = new int[17];
            int start = k;
            for (int i = 1; i < 17; i++) {
                int count = 0;
                for (int j = start; j < redList.size(); j++) {
                    if (redList.get(j).contains(i)) {
                        break;
                    }else {
                        count++;
                    }
                }
                countR[i] = count;
            }

            List<CellNumber> cellNumberList = new ArrayList<>();
            for (int i = 1; i < countR.length; i++) {
                cellNumberList.add(new CellNumber(i, countR[i],redList.get(k-1).contains(i)?1:0));
            }
            cellNumberList.sort(CellNumber::compareTo);
            List<CountNumber> countNumbers = new ArrayList<>();
            int countIndex = -1;
            for (CellNumber cellNumber : cellNumberList) {
                if(countIndex != cellNumber.count){
                    countIndex = cellNumber.count;
                    countNumbers.add(new CountNumber(""+cellNumber.number, cellNumber.count,cellNumber.isTrue));
                }else {
                    CountNumber countNumber = countNumbers.get(countNumbers.size()-1);
                    countNumber.numbers = countNumber.numbers + "+" + cellNumber.number;
                    countNumber.isContain = countNumber.isContain + cellNumber.isTrue;
                }
            }
            cellNumberListList.add(countNumbers);
        }

        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File(String.format("ssq统计蓝色%s排序.xls", date)));
            ReadExcelUtility.writeFile9(cellNumberListList, book, 1);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

        }

    static class CountNumber{
        public String numbers;
        public int count;
        public int isContain;

        public CountNumber(String numbers, int count, int isContain) {
            this.numbers = numbers;
            this.count = count;
            this.isContain = isContain;
        }
    }
}


