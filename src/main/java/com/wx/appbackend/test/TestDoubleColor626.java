package com.wx.appbackend.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestDoubleColor626 {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        int index = 67;
        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers21(index);

        List<List<Integer>> historyRed = new ArrayList<>();
        for (List<Integer> list : lastList) {
            int count = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                res.add(list.get(i));
                if (initListA.contains(list.get(i))){
                    count++;
                }
            }
            res.add(count);
            historyRed.add(res);
        }

        WritableWorkbook book = null;
        if (historyRed.size() > 0){
            try {
                book = Workbook.createWorkbook( new File(String.format("统计命中ssq%s.xls" ,index)));
                ReadExcelUtility.writeFile4(historyRed, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(1);
        initListA.add(12);
        initListA.add(3);
        initListA.add(19);
        initListA.add(28);
        initListA.add(32);

//        initListA.add(12);
//        initListA.add(14);
//        initListA.add(17);
//        initListA.add(20);
//        initListA.add(21);
//        initListA.add(26);

//        initListA.add(3);
//        initListA.add(5);
//        initListA.add(25);
//        initListA.add(31);
//        initListA.add(32);
//        initListA.add(33);

//        initListA.add(5);
//        initListA.add(12);
//        initListA.add(15);
//        initListA.add(19);
//        initListA.add(24);
//        initListA.add(26);

//        initListA.add(2);
//        initListA.add(6);
//        initListA.add(25);
//        initListA.add(33);
//        initListA.add(10);
//        initListA.add(24);
    }


}

