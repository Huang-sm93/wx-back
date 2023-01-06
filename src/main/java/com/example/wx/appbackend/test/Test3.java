package com.example.wx.appbackend.test;

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
public class Test3 {
    public static void main(String[] args) throws WriteException, IOException {
        getResult(2, 15);
    }

    public static Map<String, List<Integer>> getRedBlueList(int usedRedTimes, int usedBlueTimes){
        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",0,
                usedBlueTimes);
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        if (historyList.size() < 1){
            return null;
        }
        int[] blueCount = new int[17];
        int[] redCount = new int[34];
        for (int j = 0; j < usedBlueTimes; j++) {
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
    public static void getResult(int lastRedTimes, int lastBlueTimes) throws WriteException, IOException {
        Map<String, List<Integer>> mapList = getRedBlueList(lastRedTimes, lastBlueTimes);
        List<Integer> allBlue = mapList.get("blue");
        List<Integer> allRed = mapList.get("red");

        Random random = new Random();
        List<int[]> result = new ArrayList<>();
        List<Integer> lastTimeList = ReadExcelUtility.getLastNumber();
        lastTimeList.remove(6);
        int i = 0;
        while (i < 5) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            if (isSame(temp)){
                continue;
            }
            i++;
            result.add(temp);
        }
        WritableWorkbook book = null;
        if (result.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测结果.xls" ));
                ReadExcelUtility.writeFile(result, book, 1);
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

    public static boolean isSame(int[] cur){
        for (int i = 0; i < historyList.size(); i++) {
            int temp[] = historyList.get(i);
            if (temp[0] == cur[0] &&
                    temp[1] == cur[1] &&
                    temp[2] == cur[2] &&
                    temp[3] == cur[3] &&
                    temp[4] == cur[4] &&
                    temp[5] == cur[5] &&
                    temp[6] == cur[6]){
                return true;
            }
        }
        return false;
    }
    public static List<int[]> historyList;
    static {
        historyList = ReadExcelUtility.getAllList();
    }
}
