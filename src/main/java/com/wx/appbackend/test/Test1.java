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
public class Test1 {
    public static void main(String[] args) throws WriteException, IOException {
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("预测结果.xls" ));
            Random random = new Random();

            Map<String, List<Integer>> res = getRedBlueLis2(1);
            for (int i = 0; i < 20; i++) {
                List<int[]> list = getResult(res.get("red"), res.get("blue"), random, 10000);
                ReadExcelUtility.writeFile(list, book, i);
                System.out.println("完成了"+(i+1)*10000+"次");
            }
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
            //判断是否与之前的历史记录重复
            if (historyList.contains(temp)){
                continue;
            }
            historyList.add(temp);
            result.add(temp);
        }


        return result;
    }

    /**
     * 没有历史记录，完全随机，但是排除上几期数字
     * @param lastTimes
     * @return
     */
    public static Map<String, List<Integer>> getRedBlueLis2(int lastTimes){
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        Set<Integer> lastSet = ReadExcelUtility.getLastNumbers(lastTimes);
        for (int i = 1; i < 34; i++) {
            if (lastSet.contains(i)){
                continue;
            }
            allRed.add(i);
        }

        for (int i = 1; i < 17; i++) {
            allBlue.add(i);
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
