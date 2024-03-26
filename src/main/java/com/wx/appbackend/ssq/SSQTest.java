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
        String indexName = "0321";
        String name = String.format("/Users/ta/IdeaProjects/wx-back/src/main/java/com/wx/appbackend/ssq/ssq%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (List<Integer> numbers : myList) {
            int countR6B0 = 0;
            int countR6B1 = 0;
            int countR5B0 = 0;
            int countR5B1 = 0;
            int countR4B0 = 0;
            int countR4B1 = 0;

            int countIndex = 0;
            for (List<Integer> integers : lastList) {
                List<Integer> blueList = integers.subList(0, integers.size()-1);
                List<Integer> redList = integers.subList(integers.size()-1, integers.size());
                int countBlue = (int) numbers.subList(0,numbers.size()-1).stream().filter(blueList::contains).count();
                int countRed = numbers.get(numbers.size()-1) == redList.get(0) ? 1 : 0;
                if (countBlue == 4) {
                    if (countRed == 0) {
                        countR4B0++;
                    } else if (countRed == 1) {
                        countR4B1++;
                    }
                }else if (countBlue == 5) {
                    System.out.println("位置="+countIndex+ "\t\tcountBlue = " + countBlue +"\t" + "countRed = " + countRed + "\t" +
                            "blueList = " + blueList);
                    if (countRed == 0) {
                        countR5B0++;
                    } else if (countRed == 1) {
                        countR5B1++;
                    }
                }else if (countBlue == 6) {
                    System.out.println("位置="+countIndex+"\t\tcountBlue = " + countBlue +"\t" + "countRed = " + countRed + "\t" +
                            "blueList = " + blueList);

                    if (countRed == 0) {
                        countR6B0++;
                    } else if (countRed == 1) {
                        countR6B1++;
                    }

                }
                countIndex++;
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
//        myList.add(Arrays.asList(1,5,6,8,13,15,21,22,26,30,13));
//        myList.add(Arrays.asList(9,10,13,25,30,32,2));
//        myList.add(Arrays.asList(1,8,22,25,29,33,10));
//        myList.add(Arrays.asList(12,18,23,25,28,33,4));
        myList.add(Arrays.asList(4,8,13,15,23,26,13));
        myList.add(Arrays.asList(7,1,17,16,30,26,13));
        myList.add(Arrays.asList(4,10,14,23,30,26,13));

    }
}



