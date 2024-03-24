package com.wx.appbackend.bfun;

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
public class BigFunTest1 {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0322";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/bfun/bf%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (int i = 0; i < 1; i++) {
            for (List<Integer> integers : lastList) {
                List<Integer> blueList = integers.subList(0, 5);
                List<Integer> redList = integers.subList(5, 7);
                int countBlue = (int) myRedList.get(i).stream().filter(blueList::contains).count();
                int countRed = (int) myBlueList.get(i).stream().filter(redList::contains).count();
                if (countBlue == 4 && countRed == 0) {
                    System.out.println("countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                } else if (countBlue == 4 && countRed == 1) {
                    System.out.println( "countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                } else if (countBlue == 4 && countRed == 2) {
                    System.out.println( "countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                }else if (countBlue == 5 && countRed == 0) {
                    System.out.println("countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                }else if (countBlue == 5 && countRed == 1) {
                    System.out.println("countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                }else if (countBlue == 5 && countRed == 2) {
                    System.out.println("countBlue = " + countBlue + "\t" + "countRed = " + countRed + "\t"+ integers);
                }
            }
            System.out.println("numbers = " + myRedList + myBlueList);
            //分割线
        }
    }

    private static final List<List<Integer>> myRedList = new ArrayList<>();
    private static final List<List<Integer>> myBlueList = new ArrayList<>();

    static {
        myRedList.add(Arrays.asList(4, 5, 9, 19, 28, 24, 28, 34));
        myBlueList.add(Arrays.asList(4, 5, 9, 10));
    }
}



