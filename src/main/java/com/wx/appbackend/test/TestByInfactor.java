package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/10/26
 */
public class TestByInfactor {
    public static void main(String[] args) throws WriteException, IOException {
        getResult();
    }

    public static void getResult() throws WriteException, IOException {
        List<int[]> result = getResult2(100);
        WritableWorkbook book = null;
        if (result.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测结果.xls" ));
                ReadExcelUtility.writeFile12(result, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }

    /**
     * 完全随机
     * @param outListSize
     * @return
     */
    public static List<int[]> getResult2(int outListSize){
        List<int[]> result = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        for (int i = 1; i < 34; i++) {
            allRed.add(i);
        }

        Random random = new Random();
        int maxTimes = 100000;
        List<Integer> finalList = new ArrayList<>();
        finalList.add(historyList.get(0)[0]);
        finalList.add(historyList.get(0)[1]);
        finalList.add(historyList.get(0)[2]);
        finalList.add(historyList.get(0)[3]);
        finalList.add(historyList.get(0)[4]);
        finalList.add(historyList.get(0)[5]);

        for (int i = 0; i < maxTimes; i++) {
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            int sum = temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5];
            Arrays.sort(temp);
            //加入排除条件
            if (isSame(temp) || sum>90){
                continue;
            }
            //命中数
            int count = 0;

            for (int j = 0; j < 6; j++) {
                if (finalList.contains(temp[j])){
                    count++;
                }
            }
            temp[6] = count;
            result.add(temp);
            outListSize--;
            System.out.println(i);
            if (outListSize < 1){
                break;
            }
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

    public static boolean isSame(int[] cur){
        for (int i = 1; i < historyList.size(); i++) {
            int temp[] = historyList.get(i);
            if (temp[0] == cur[0] &&
                    temp[1] == cur[1] &&
                    temp[2] == cur[2] &&
                    temp[3] == cur[3] &&
                    temp[4] == cur[4] &&
                    temp[5] == cur[5]){
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
