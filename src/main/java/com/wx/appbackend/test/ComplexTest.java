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
    排除上几期同时考虑更前几期出现次数作为权重
 */
public class ComplexTest {
    public static void main(String[] args) throws WriteException, IOException {
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("预测结果.xls" ));
            Random random = new Random();
            int selectRed = 8;
            int selectBlue = 2;
            Map<String, List<Integer>> res = getListByParams(2, 0, 0);
            List<List<Integer>> list = getResult(res.get("red"), res.get("blue"), random, selectRed, selectBlue, 10000);
            ReadExcelUtility.writeFile(list, book, selectRed, selectBlue);

            book.write();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (book != null){
                book.close();
            }
        }
    }


    public static List<List<Integer>> getResult(List<Integer> allRed, List<Integer> allBlue, Random random,int red, int blue, int outListSize){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < red; j++) {
                temp.add(getRandomNum(redTemp, random));
            }
            for (int j = 0; j < blue; j++) {
                temp.add(getRandomNum(blueTemp, random));
            }
            result.add(temp);
        }


        return result;
    }

    /**
     * 没有历史记录，完全随机，但是排除上几期数字
     * @return
     */
    public static Map<String, List<Integer>> getListByParams(int removeLastTimes, int usedRedTimes, int usedBlueTimes){
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",0,
                usedBlueTimes+removeLastTimes);
        Set<Integer> lastSet = ReadExcelUtility.getLastNumbers(removeLastTimes);
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        if (historyList.size() < 1){
            return null;
        }
        int[] blueCount = new int[17];
        int[] redCount = new int[34];
        for (int j = removeLastTimes; j < usedBlueTimes+removeLastTimes; j++) {
            CellInfo cellInfo = historyList.get(j);
            blueCount[cellInfo.values[6]] = blueCount[cellInfo.values[6]] + 1;
            if (j < usedRedTimes){
                redCount[cellInfo.values[0]] = redCount[cellInfo.values[0]] + 1;
                redCount[cellInfo.values[1]] = redCount[cellInfo.values[1]] + 1;
                redCount[cellInfo.values[2]] = redCount[cellInfo.values[2]] + 1;
                redCount[cellInfo.values[3]] = redCount[cellInfo.values[3]] + 1;
                redCount[cellInfo.values[4]] = redCount[cellInfo.values[4]] + 1;
                redCount[cellInfo.values[5]] = redCount[cellInfo.values[5]] + 1;
            }
        }

        for (int i = 1; i < redCount.length; i++) {
            if (lastSet.contains(redCount[i])){
                continue;
            }
            for (int j = 0; j < usedRedTimes+1 - redCount[i]; j++) {
                allRed.add(i);
            }
        }

        for (int i = 1; i < blueCount.length; i++) {
            for (int j = 0; j < usedBlueTimes+1 - blueCount[i]; j++) {
                allBlue.add(i);
            }
        }

        result.put("red", allRed);
        result.put("blue", allBlue);

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

    public static List<int[]> historyList;
    static {
        historyList = ReadExcelUtility.getAllList();
    }
}
