package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/12/16
 */
public class CalculateBySum {
    public static void main(String[] args) {
        try {
            getAll();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAll() throws WriteException, IOException {
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",0,
                3000);
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("统计结果.xls" ));

            int times = 10;
            for (int i = 0; i < times; i++) {
                WritableSheet sheet = book.createSheet( 2933-i+"" , i);
                int[] redCount = new int[34];
                int[] blueCount = new int[17];
                for (int j = i+1; j < historyList.size(); j++) {
                    redCount[historyList.get(j).values[0]] = redCount[historyList.get(j).values[0]] + 1;
                    redCount[historyList.get(j).values[1]] = redCount[historyList.get(j).values[1]] + 1;
                    redCount[historyList.get(j).values[2]] = redCount[historyList.get(j).values[2]] + 1;
                    redCount[historyList.get(j).values[3]] = redCount[historyList.get(j).values[3]] + 1;
                    redCount[historyList.get(j).values[4]] = redCount[historyList.get(j).values[4]] + 1;
                    redCount[historyList.get(j).values[5]] = redCount[historyList.get(j).values[5]] + 1;
                    blueCount[historyList.get(j).values[6]] = blueCount[historyList.get(j).values[6]] + 1;
                }
                List<CellCount> redCellList = new ArrayList<>();
                for (int j = 1; j < redCount.length; j++) {
                    CellCount cellCount = new CellCount();
                    cellCount.times = redCount[j];
                    cellCount.value = j;
                    redCellList.add(cellCount);
                }
                Collections.sort(redCellList);
                List<CellCount> blueCellList = new ArrayList<>();
                for (int j = 1; j < blueCount.length; j++) {
                    CellCount cellCount = new CellCount();
                    cellCount.times = blueCount[j];
                    cellCount.value = j;
                    blueCellList.add(cellCount);
                }
                Collections.sort(blueCellList);
                List<CellCount> result = new ArrayList<>();
                int[] history = historyList.get(i).values;
                for (int j = 0; j < 7; j++) {
                    if (j == 6){
                        for (int k = 0; k < blueCellList.size(); k++) {
                            if (blueCellList.get(k).value == history[j]){
                                CellCount count = blueCellList.get(k);
                                count.sortIndex = k;
                                result.add(count);
                                break;
                            }
                        }
                    }else {
                        int countTimes = 0;
                        for (int k = 0; k < redCellList.size(); k++) {
                            if (countTimes<5 && redCellList.get(k).value == history[j]){
                                CellCount count = redCellList.get(k);
                                count.sortIndex = k;
                                result.add(count);
                            }
                        }
                    }
                }

                for (int j = 0; j < result.size(); j++) {
                    //出现的次数
                    Number number1 = new Number( 0 , j, result.get(j).times);
                    Number number2 = new Number( 1 , j, result.get(j).sortIndex);
                    Number number3 = new Number( 2 , j, result.get(j).value);
                    sheet.addCell(number1);
                    sheet.addCell(number2);
                    sheet.addCell(number3);
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
        @Override
        public int compareTo(CellCount o) {
            return this.times-o.times;
        }

        public int sortIndex;
        public int times;
        public int value;
    }
}
