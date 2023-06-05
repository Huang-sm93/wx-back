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
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFunByLastTimes {
    public static void main(String[] args) throws WriteException, IOException {
        int s = 5;
        List<Integer> lastRedNumbers = ReadExcelUtility.getBFLastRedNumbers(
                "D:\\Work\\wx-app-backend-master\\BG近100次历史记录1.xls", s, s);

        int startTimes = 4+s;
        int endTimes = startTimes+1;
        int size = 6;
        List<List<Integer>> mostRedList = getMostRed(startTimes, endTimes, size);

        List<Integer> canSelectList = mostRedList.get(0);
        List<Integer> preCanSelectList= mostRedList.get(0).subList(1, 8);
        List<Integer> postCanSelectList= mostRedList.get(0).subList(mostRedList.get(0).size()-12, mostRedList.get(0).size());

        System.out.println("总计"+canSelectList.size()+":" + canSelectList);
        System.out.println("mostRedList:" + preCanSelectList);
        System.out.println("mostRedList:" + postCanSelectList);

        List<int[]> calculateList = new ArrayList<>();
        Random random = new Random();
        int selectSize = 5;
//        // 选择方式1
//        for (int i = 0; i < 10000; i++) {
//            int[] temp = new int[selectSize];
//            List<Integer> tempList = new ArrayList<>(canSelectList);
//            for (int j = 0; j < selectSize; j++) {
//                int index = random.nextInt(tempList.size());
//                temp[j] = tempList.get(index);
//                tempList.remove(index);
//            }
//            calculateList.add(temp);
//        }

        // 选择方式2
        for (int i = 0; i < 1000; i++) {
            int[] temp = new int[selectSize];
            List<Integer> tempList1 = new ArrayList<>(preCanSelectList);
            List<Integer> tempList2 = new ArrayList<>(postCanSelectList);
            for (int j = 0; j < 2; j++) {
                int index = random.nextInt(tempList1.size());
                temp[j] = tempList1.get(index);
                tempList1.remove(index);
            }

            for (int j = 2; j < selectSize; j++) {
                int index = random.nextInt(tempList2.size());
                temp[j] = tempList2.get(index);
                tempList2.remove(index);
            }

            calculateList.add(temp);
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < calculateList.size(); i++) {
            int[] temp = new int[selectSize+2];
            int countRed = 0;
            for (int j = 0; j < calculateList.get(i).length; j++) {
                temp[j] = calculateList.get(i)[j];
                if (lastRedNumbers.contains(calculateList.get(i)[j])){
                    countRed++;
                }
            }
            temp[selectSize+1] = countRed;
            temp[selectSize] = i;
            result.add(temp);
        }
                WritableWorkbook book = null;
        if (result.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("两种测试.xls" ));
                ReadExcelUtility.writeFile2(result, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

        CellNumber[] allRed = new CellNumber[36];
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int j = 0; j < result.size(); j++) {
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int k = 0; k < 5; k++) {
                int index = result.get(j)[k];
                if (allRed[index] == null){
                    allRed[index] = new CellNumber(index, 0);
                }
                allRed[index].count = allRed[index].count + 1;
            }
        }
        List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o->o.number).collect(Collectors.toList());
        System.out.println("redList:" + redList.subList(0, 6));
    }

    public static List<List<Integer>> getMostRed(int startTimes, int endTimes, int size) throws WriteException, IOException {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = startTimes; i < endTimes; i++) {
            List<CellInfo> list = ReadExcelUtility.getArrFileNameNew("D:\\Work\\wx-app-backend-master\\BG近100次历史记录1.xls", i, i+size);
            CellNumber[] allRed = new CellNumber[36];
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int j = 0; j < list.size(); j++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int k = 0; k < 5; k++) {
                    int index = list.get(j).values[k];
                    if (allRed[index] == null){
                        allRed[index] = new CellNumber(index, 0);
                    }
                    allRed[index].count = allRed[index].count + 1;
                }
            }
            List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o->o.number).collect(Collectors.toList());
            result.add(redList);
        }
        return result;
    }
    public static List<Integer> getCalculateResult(List<Integer> input, int outSize) throws WriteException, IOException {
        List<Integer> redAll = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < outSize; i++) {
            int index = random.nextInt(input.size());
            int red = input.get(index);
            redAll.add(red);
            input.remove(index);
        }

        return redAll;
    }

    public static List<int[]> getResult(List<Integer> allRed, Random random, int outListSize){
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[5];
            for (int j = 0; j < 5; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            Arrays.sort(temp);
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

}

