package com.wx.appbackend.test;

import io.swagger.models.auth.In;
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
    排除上几期
 */
public class TestRemoveLastTimeNumberWithoutInfactor {
    public static void main(String[] args) throws WriteException, IOException {

//        WritableWorkbook book = null;
//        try {
//            book = Workbook.createWorkbook( new File("预测结果.xls" ));
//            Random random = new Random();
//
//            Map<String, List<Integer>> res = getListByParams(2);
//            List<int[]> list = getResult(res.get("red"), res.get("blue"), random, 10000);
//            ReadExcelUtility.writeFile(list, book, 0);
//
//            book.write();
//        } catch (WriteException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if (book != null){
//                book.close();
//            }
//        }
        List<Integer> redAll = new ArrayList<>();
        redAll.add(14);
        redAll.add(16);
        redAll.add(19);
        redAll.add(23);
        redAll.add(28);
        redAll.add(30);
        su();
        ReadExcelUtility.calculatePrize(redAll, 3);
    }


    public static List<int[]> getResult(List<Integer> allBlue, List<Integer> allRed, Random random, int outListSize){
        List<int[]> result = new ArrayList<>();
        int countSize = 0;
        while(countSize < outListSize){
            List<Integer> redTemp = new ArrayList<>(allRed);
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            //判断是否与之前的历史记录重复
            if (historyList.contains(temp)){
                continue;
            }
            //判断数字和大小
//            int sum = temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]+temp[6];
//            if (sum < 108){
//                continue;
//            }
            historyList.add(temp);
            result.add(temp);
            countSize++;
        }


        return result;
    }

    /**
     * 没有历史记录，完全随机，但是排除上几期数字
     * @return
     */
    public static Map<String, List<Integer>> getListByParams(int removeLastTimes){
        Set<Integer> lastSet = ReadExcelUtility.getLastNumbers(removeLastTimes);
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        int[] blueCount = new int[17];
        int[] redCount = new int[34];

        for (int i = 1; i < redCount.length; i++) {
            if (lastSet.contains(redCount[i])){
                continue;
            }
            allRed.add(i);
        }

        for (int i = 1; i < blueCount.length; i++) {
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

    public static void su() throws WriteException, IOException {
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        Set<Integer> lastSet = new HashSet<>();
        int[] ins = {2,3,14,21,29,32,6,7,18,23,27,30};
        for (int in : ins) {
            lastSet.add(in);
        }
        int[] blueCount = new int[17];
        int[] redCount = new int[34];

        for (int i = 1; i < redCount.length; i++) {
            if (lastSet.contains(i)){
                continue;
            }
            allRed.add(i);
        }

        for (int i = 1; i < blueCount.length; i++) {
            allBlue.add(i);
        }
        Random random = new Random();
        List<int[]> list = getResult(allBlue,allRed, random, 10000);
//        for (int[] ints : list) {
//            System.out.println(ints[0]+"  " + ints[1] + "  "+ ints[2] + "  "+ ints[3] + "  "+ ints[4] + "  "+ ints[5] + "  "+ ints[6] + "  ");
//        }
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("预测结果.xls" ));
            ReadExcelUtility.writeFile12(list, book, 0);

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


}
