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
public class CalculateIndexBFBLUEOrderByCount {

    public static void main(String[] args) throws WriteException, IOException {
        String date = "1216";
        List<List<Integer>> redList = ReadExcelUtility.getBFBlueLastNumbersAll(date);
        List<List<CalculateIndexDCBLUEOrderByCount.CountNumber>> cellNumberListList = new ArrayList<>();
        for (int k = 1; k < 31; k++) {
            int[] countR = new int[13];
            int start = k;
            for (int i = 1; i < 13; i++) {
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
            List<CalculateIndexDCBLUEOrderByCount.CountNumber> countNumbers = new ArrayList<>();
            int countIndex = -1;
            for (CellNumber cellNumber : cellNumberList) {
                if(countIndex != cellNumber.count){
                    countIndex = cellNumber.count;
                    countNumbers.add(new CalculateIndexDCBLUEOrderByCount.CountNumber(""+cellNumber.number, cellNumber.count,cellNumber.isTrue));
                }else {
                    CalculateIndexDCBLUEOrderByCount.CountNumber countNumber = countNumbers.get(countNumbers.size()-1);
                    countNumber.numbers = countNumber.numbers + "+" + cellNumber.number;
                    countNumber.isContain = countNumber.isContain + cellNumber.isTrue;
                }
            }
            cellNumberListList.add(countNumbers);
        }

        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("BF统计蓝色1209排序.xls"));
            ReadExcelUtility.writeFile9(cellNumberListList, book, 1);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

        }
}


