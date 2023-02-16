package com.wx.appbackend.test;

import io.swagger.models.auth.In;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/10/26
 */
public class CalculateByParams {
    public static void main(String[] args) throws WriteException, IOException {
        calculate();
    }


    public static void calculate() throws WriteException, IOException {
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName(
                "D:\\Work\\wx-app-backend-master\\历史记录.xls",0, 3000);
        WritableWorkbook writableWorkbook = null;
        try {
            writableWorkbook = Workbook.createWorkbook(new File("各种因素统计.xls" ));
            WritableSheet writableSheet = writableWorkbook.createSheet( " 第"+1+"页 " , 0);
            //写title
            Label title1 = new Label(0, 0, "红1");
            Label title2 = new Label(1, 0, "红2");
            Label title3 = new Label(2, 0, "红3");
            Label title4 = new Label(3, 0, "红4");
            Label title5 = new Label(4, 0, "红5");
            Label title6 = new Label(5, 0, "红6");
            Label title7 = new Label(6, 0, "蓝");
            Label title8 = new Label(7, 0, "与上期相同个数");
            writableSheet.addCell(title1);
            writableSheet.addCell(title2);
            writableSheet.addCell(title3);
            writableSheet.addCell(title4);
            writableSheet.addCell(title5);
            writableSheet.addCell(title6);
            writableSheet.addCell(title7);
            writableSheet.addCell(title8);
            Label title9 = new Label(8, 0, "日期hash红");
            writableSheet.addCell(title9);
            Label title10 = new Label(9, 0, "日期hash蓝");
            writableSheet.addCell(title10);

            for (int i = 0; i < historyList.size()-1; i++) {
                Number number1 = new Number( 0 , i+1, historyList.get(i).values[0]);
                Number number2 = new Number( 1 , i+1, historyList.get(i).values[1]);
                Number number3 = new Number( 2 , i+1, historyList.get(i).values[2]);
                Number number4 = new Number( 3 , i+1, historyList.get(i).values[3]);
                Number number5 = new Number( 4 , i+1, historyList.get(i).values[4]);
                Number number6 = new Number( 5 , i+1, historyList.get(i).values[5]);
                Number number7 = new Number( 6 , i+1, historyList.get(i).values[6]);
                writableSheet.addCell(number1);
                writableSheet.addCell(number2);
                writableSheet.addCell(number3);
                writableSheet.addCell(number4);
                writableSheet.addCell(number5);
                writableSheet.addCell(number6);
                writableSheet.addCell(number7);
                //1 计算与前1期相同的个数
                int countSameRedNum = countSameNumWithLastTime(historyList.get(i).redValues, historyList.get(i+1).redValues);
                Number number8 = new Number( 7 , i+1, countSameRedNum);
                writableSheet.addCell(number8);
                int dateHashRed = historyList.get(i).calendarDate.hashCode()%33;
                int dateHashBlue = historyList.get(i).calendarDate.hashCode()%16;
                Number number9 = new Number( 8 , i+1, dateHashRed == 0 ? 33 : dateHashRed);
                writableSheet.addCell(number9);
                Number number10 = new Number( 9 , i+1, dateHashBlue == 0 ? 16 : dateHashBlue);
                writableSheet.addCell(number10);

            }

            writableWorkbook.write();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (writableWorkbook != null){
                writableWorkbook.close();
            }
        }
    }

    private static int countSameNumWithLastTime(List<Integer> currentValues, List<Integer> lastValues) {
        int countSameNum = 0;
        for (Integer currentValue : currentValues) {
            if (lastValues.contains(currentValue)){
                countSameNum++;
            }
        }
        return countSameNum;
    }

    public static List<int[]> historyList;
    static {
        historyList = ReadExcelUtility.getAllList();
    }
}
