package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/12/16
 */
public class CountLastTimeUtil {
    public static void main(String[] args) {
        try {
            getAll1();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //统计最近N次各个数字出现的次数
    public static void getAll() throws WriteException, IOException {
        int usedTimes = 101;
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",
                0,
                4000);
        List<Integer> finalList = Arrays.asList(historyList.get(0).values[0],
                historyList.get(0).values[1],
                historyList.get(0).values[2],
                historyList.get(0).values[3],
                historyList.get(0).values[4],
                historyList.get(0).values[5]);
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("最近统计结果1.xls" ));
            int[] redCount = new int[34];
            for (int j = 1; j < usedTimes; j=j+1) {
                WritableSheet sheet = book.createSheet( "最近"+j+"次" , j);
                Label label1 = new Label( 0 , 0, "号码"); // 号码
                Label label2 = new Label( 1 , 0, "出现次数");//出现次数
                Label label3 = new Label( 2 , 0, "实际");   //是否命中
//                Label label4 = new Label( 3 , 0, "是否命中");   //
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
                redCount[historyList.get(j).values[0]] = redCount[historyList.get(j).values[0]] + 1;
                redCount[historyList.get(j).values[1]] = redCount[historyList.get(j).values[1]] + 1;
                redCount[historyList.get(j).values[2]] = redCount[historyList.get(j).values[2]] + 1;
                redCount[historyList.get(j).values[3]] = redCount[historyList.get(j).values[3]] + 1;
                redCount[historyList.get(j).values[4]] = redCount[historyList.get(j).values[4]] + 1;
                redCount[historyList.get(j).values[5]] = redCount[historyList.get(j).values[5]] + 1;
                //出现的次数
                for (int i = 1; i < redCount.length; i++) {
                    Number number4 = new Number( 0 , i, i); // 数值
                    Number number5 = new Number( 1 , i, redCount[i]);//出现次数
                    sheet.addCell(number4);
                    sheet.addCell(number5);
                    int flag = 0;
                    if(finalList.contains(i)){
                        flag = 1;
                    }
                    Number number6 = new Number( 2 , i, flag);   //是否命中
                    sheet.addCell(number6);
                }

            }

            book.write();
        } catch (IOException | WriteException e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

    }

    //统计
    public static void getAll1() throws WriteException, IOException {
        int usedTimes = 50;
        int lastTimes = 10;
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",
                0,
                4000);

        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("使用最近"+usedTimes + "次统计.xls" ));

            for (int j = 1; j <= lastTimes; j++) {
                List<Integer> finalList = Arrays.asList(historyList.get(j-1).values[0],
                        historyList.get(j-1).values[1],
                        historyList.get(j-1).values[2],
                        historyList.get(j-1).values[3],
                        historyList.get(j-1).values[4],
                        historyList.get(j-1).values[5]);
                int[] redCount = new int[34];
                WritableSheet sheet = book.createSheet( "最近"+j+"期" , j);
                Label label1 = new Label( 0 , 0, "号码"); // 号码
                Label label2 = new Label( 1 , 0, "出现次数");//出现次数
                Label label3 = new Label( 2 , 0, "实际");   //是否命中
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
                for (int i = j; i < usedTimes+j; i++) {
                    redCount[historyList.get(i).values[0]] = redCount[historyList.get(i).values[0]] + 1;
                    redCount[historyList.get(i).values[1]] = redCount[historyList.get(i).values[1]] + 1;
                    redCount[historyList.get(i).values[2]] = redCount[historyList.get(i).values[2]] + 1;
                    redCount[historyList.get(i).values[3]] = redCount[historyList.get(i).values[3]] + 1;
                    redCount[historyList.get(i).values[4]] = redCount[historyList.get(i).values[4]] + 1;
                    redCount[historyList.get(i).values[5]] = redCount[historyList.get(i).values[5]] + 1;
                }
                List<CellCount> redCellList = new ArrayList<>();
                for (int i = 1; i < redCount.length; i++) {
                    CellCount cellCount = new CellCount();
                    cellCount.times = redCount[i];
                    cellCount.value = i;
                    redCellList.add(cellCount);
                }
                Collections.sort(redCellList);
                for (int i = 0; i < redCellList.size(); i++) {
                    Number number4 = new Number( 0 , i+1, redCellList.get(i).value); // 数值
                    Number number5 = new Number( 1 , i+1, redCellList.get(i).times);//出现次数
                    sheet.addCell(number4);
                    sheet.addCell(number5);
                    int flag = 0;
                    if(finalList.contains(redCellList.get(i).value)){
                        flag = 1;
                    }
                    Number number6 = new Number( 2 , i+1, flag);   //是否命中
                    sheet.addCell(number6);
                }

            }

            book.write();
        } catch (IOException | WriteException e) {
            throw new RuntimeException(e);
        }finally {
            book.close();
        }

    }

    public static List<int[]> getResult(List<Integer> allBlue, List<Integer> allRed, Random random, int outListSize){
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(blueTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(redTemp, random);
            result.add(temp);
        }


        return result;
    }

    public static int getRandomNum(List<Integer> blueCount, Random random){

        int randNum = random.nextInt(blueCount.size());
        int count = blueCount.get(randNum);
        boolean flag = true;
        while (flag){
            flag = blueCount.remove(new Integer(count));
        }
        return count;
    }

    static class CellCount implements Comparable<CellCount>{

        //从大到小排序
        @Override
        public int compareTo(CellCount o) {
            return o.times - this.times;
        }

        public int sortIndex;
        public int times;

        public int value;
    }
}
