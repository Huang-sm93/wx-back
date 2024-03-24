package com.wx.appbackend.bfun;

import com.wx.appbackend.test.CellNumber;
import com.wx.appbackend.test.ReadExcelUtility;
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
public class BigFunTest {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0315";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/bfun/bf%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (List<Integer> numbers : myList) {
            int countR3B2 = 0;
            int countR4B0 = 0;
            int countR4B1 = 0;
            int countR4B2 = 0;
            for (List<Integer> integers : lastList) {
                List<Integer> blueList = integers.subList(0, 5);
                List<Integer> redList = integers.subList(5, 7);
                int countBlue = (int) numbers.stream().filter(blueList::contains).count();
                int countRed = (int) numbers.stream().filter(redList::contains).count();
                if (countBlue == 3 && countRed == 2) {
                    countR3B2++;
                } else if (countBlue >= 4 && countRed == 0) {
                    countR4B0++;
                } else if (countBlue >= 4 && countRed == 1) {
                    countR4B1++;
                } else if (countBlue >= 4 && countRed == 2) {
                    countR4B2++;
                }
            }
            System.out.println("numbers = " + numbers + "\t"+
                    "countR3B2 = " + countR3B2 + "\t" +
                    "countR4B0 = " + countR4B0 + "\t" +
                    "countR4B1 = " + countR4B1 + "\t" +
                    "countR4B2 = " + countR4B2);
            //分割线
        }
    }

    private static final List<List<Integer>> myList = new ArrayList<>();

    static {
        myList.add(Arrays.asList(4, 19, 24, 28, 34, 4, 5));
    }
}



