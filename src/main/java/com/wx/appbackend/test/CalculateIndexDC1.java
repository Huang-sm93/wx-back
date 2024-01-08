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
public class CalculateIndexDC1 {

    public static void main(String[] args) throws WriteException, IOException {
        String date = "20240108";
        List<Long> redList = ReadExcelUtility.getDCLastNumbersAll1();
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File(String.format("统计%s.xls", date)));
            ReadExcelUtility.writeFile18(redList, book, 1);
            book.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

    }
}


