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
public class CalculateIndexDC {

    public static void main(String[] args) throws WriteException, IOException {
        String date = "1220";
        List<List<Integer>> redList = ReadExcelUtility.getDCLastNumbersAll(date);
        List<List<CellNumber>> cellNumberListList = new ArrayList<>();
        for (int k = 0; k <31; k++) {
            int[] countR = new int[34];
            int start = k;
            for (int i = 1; i < 34; i++) {
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
                cellNumberList.add(new CellNumber(i, countR[i], k>0 &&redList.get(k-1).contains(i)?1:0));
            }
            cellNumberList.sort(CellNumber::compareTo);
            cellNumberListList.add(cellNumberList);
        }

        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File(String.format("ssq统计红色%s.xls", date)));
            ReadExcelUtility.writeFile8(cellNumberListList, book, 1);
            ReadExcelUtility.writeFile8Sheet2(cellNumberListList, book, 2);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

    }
}


