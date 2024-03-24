package com.wx.appbackend.ssq;

import com.wx.appbackend.test.ReadExcelUtility;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class SSQTest {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0315";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/ssq/ssq%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (List<Integer> numbers : myList) {
            int countR6B0 = 0;
            int countR6B1 = 0;
            int countR5B0 = 0;
            int countR5B1 = 0;
            int countR4B0 = 0;
            int countR4B1 = 0;

            for (List<Integer> integers : lastList) {
                List<Integer> blueList = integers.subList(0, 6);
                List<Integer> redList = integers.subList(6, 7);
                int countBlue = (int) numbers.subList(0,numbers.size()-1).stream().filter(blueList::contains).count();
                int countRed = numbers.get(numbers.size()-1) == redList.get(0) ? 1 : 0;
                if (countBlue == 4) {
                    if (countRed == 0) {
                        countR4B0++;
                    } else if (countRed == 1) {
                        countR4B1++;
                    }
                }else if (countBlue == 5) {
                    System.out.println("countBlue = " + countBlue +"\t" + "countRed = " + countRed + "\t" +
                            "blueList = " + blueList);
                    if (countRed == 0) {
                        countR5B0++;
                    } else if (countRed == 1) {
                        countR5B1++;
                    }
                }else if (countBlue == 6) {
                    System.out.println("countBlue = " + countBlue +"\t" + "countRed = " + countRed + "\t" +
                            "blueList = " + blueList);

                    if (countRed == 0) {
                        countR6B0++;
                    } else if (countRed == 1) {
                        countR6B1++;
                    }

                }
            }
            System.out.println("numbers = " + numbers + "\t"+
                    "countR4B0 = " + countR4B0 + "\t" +
                    "countR4B1 = " + countR4B1 + "\t" +
                    "countR5B0 = " + countR5B0 + "\t" +
                    "countR5B1 = " + countR5B1 + "\t" +
                    "countR6B0 = " + countR6B0 + "\t" +
                    "countR6B1 = " + countR6B1 + "\t");
            //分割线
        }
    }

    private static final List<List<Integer>> myList = new ArrayList<>();

    static {
        myList.add(Arrays.asList(1,8,22,25,29,33,21,24,32, 10));
        myList.add(Arrays.asList(2,5,9,13,15,19,22,24,29, 5));
        myList.add(Arrays.asList(6,8,12,15,17,18,22,29,30, 7));
        myList.add(Arrays.asList(9,10,13,25,32,30,22,23,31, 2));
    }
}



