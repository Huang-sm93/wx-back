package com.example.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/10/26
 */
public class CalculateDeta {
    public static void main(String[] args) throws Exception {
        calculateDerta();
    }

    public static void calculateDerta() throws Exception{
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",
                1,
                4000);
        for (int i = 0; i < historyList.size(); i++) {
            CellInfo cellInfo = historyList.get(i);
            double[] redValues = {cellInfo.values[0],
                    cellInfo.values[1],
                    cellInfo.values[2],
                    cellInfo.values[3],
                    cellInfo.values[4],
                    cellInfo.values[5]};
            cellInfo.deta = getVariance(redValues);
        }
        WritableWorkbook book = null;
        if (historyList.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("历史记录deta.xls" ));
                // 获取第一张工作表
                WritableSheet sheet = book.createSheet( " 第1页 " , 0);
                for (int i = 0; i < historyList.size(); i++) {
                    Number number1 = new Number( 0 , i, historyList.get(i).deta);
                    sheet.addCell(number1);
                }
                book.write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
    }

    public static double getVariance(double[] x) {
            int m=x.length;
            double sum=0;
            for(int i=0;i<m;i++){//求和
                sum+=x[i];
            }
            double dAve=sum/m;//求平均值
            double dVar=0;
            for(int i=0;i<m;i++){//求方差
                dVar+=(x[i]-dAve)*(x[i]-dAve);
            }
            return dVar/m;
    }
}
