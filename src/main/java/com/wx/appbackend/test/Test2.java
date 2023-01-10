package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/10/26
 */
public class Test2 {
    public static void main(String[] args) throws WriteException, IOException {
        getResult(10000000, 2);
    }

    public static Map<String, List<Integer>> getRedBlueList(int usedTimes){
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",usedTimes);
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        if (historyList.size() < 1){
            return null;
        }
        int[] blueCount = new int[17];
        int[] redCount = new int[34];
        for (CellInfo cellInfo : historyList) {
            for (int i = 0; i < cellInfo.values.length; i++) {
                if (i == 6){
                    blueCount[cellInfo.values[i]] = blueCount[cellInfo.values[i]] + 1;
                }else {
                    redCount[cellInfo.values[i]] = redCount[cellInfo.values[i]] + 1;
                }
            }
        }

        int times = historyList.size() + 1;
        for (int i = 1; i < redCount.length; i++) {
            for (int j = 0; j < times - redCount[i]; j++) {
                allRed.add(i);
            }
        }

        for (int i = 1; i < blueCount.length; i++) {
            for (int j = 0; j < times - blueCount[i]; j++) {
                allBlue.add(i);
            }
        }

        result.put("red", allRed);
        result.put("blue", allBlue);

        return result;
    }
    public static void getResult(int testTimes, int lastTimes) throws WriteException, IOException {
        Map<String, List<Integer>> mapList = getRedBlueList(lastTimes);
        List<Integer> allBlue = mapList.get("blue");
        List<Integer> allRed = mapList.get("red");

        Random random = new Random();
        List<int[]> result = new ArrayList<>();
        List<Integer> lastTimeList = ReadExcelUtility.getLastNumber();
        lastTimeList.remove(6);
        for (int i = 0; i < testTimes; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[8];
            temp[6] = 40;
            temp[7] = 40;
            int countRed = 0;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
                if (lastTimeList.contains(temp[j])){
                    countRed++;
                }
            }
            if (countRed < 6){
                continue;
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            result.add(temp);
            temp[7] = i;
            System.out.println("这是第"+i+"次");
        }
        WritableWorkbook book = null;
        if (result.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测结果.xls" ));
                ReadExcelUtility.writeFile1(result, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

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

    public static List<int[]> historyList;
    static {
        historyList = ReadExcelUtility.getAllList();
    }
}
