package com.example.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.Number;
import jxl.write.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/12/16
 */
public class CalculateByHashDateUtil {
    public static void main(String[] args) {
        try {
            getAll1();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
