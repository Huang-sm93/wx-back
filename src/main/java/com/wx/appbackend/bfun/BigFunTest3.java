package com.wx.appbackend.bfun;

import com.wx.appbackend.test.CellNumber;
import com.wx.appbackend.test.ReadExcelUtility;
import jxl.write.WriteException;

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
public class BigFunTest3 {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "031";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/bfun/bf%s红.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersBFRAll(name);
        int startIndex = 0;
        List<Integer> canSelectedList = new ArrayList<>();
        int lastTime = 35;
        int maxCount = 10000;
//        int[] lastNumbers = new int[36];
//        for (int i = startIndex+1; i < startIndex+1+lastTime; i++) {
//            List<Integer> integers = lastList.get(i);
//            for (int j = 0; j < 5; j++) {
//                lastNumbers[integers.get(j)]++;
//            }
//        }
        CellNumber[] allRed = new CellNumber[36];
        for (int i = startIndex+1; i < startIndex+1+lastTime; i++) {
            List<Integer> integers = lastList.get(i);
            for (int j = 0; j < integers.size(); j++) {
                if (allRed[integers.get(j)] == null){
                    allRed[integers.get(j)] = new CellNumber(integers.get(j), 0);
                }
                allRed[integers.get(j)].count++;
            }

        }



//        CellNumber[] allRed = new CellNumber[36];
//        for (int i = 1; i < 36; i++) {
//            allRed[i] = new CellNumber(i, 0);
//        }
//
//        for (int i = 0; i < maxCount; i++) {
//            getResult(canSelectedList, lastList.get(startIndex).subList(0,5), allRed);
//        }

        List<CellNumber> redList = Arrays.stream(allRed).filter(o -> o != null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
        for (CellNumber cellNumber : redList) {
            System.out.println("number = " + cellNumber.number + "\t" + "count = " + cellNumber.count);
        }

        System.out.println("numbers = " + lastList.get(startIndex));
    }

    public static List<Integer> getResult(List<Integer> allRed, List<Integer> lastList, CellNumber[] allNumbers){
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        List<Integer> redTemp = new ArrayList<>(allRed);
        int countRed = 0;
        for (int j = 0; j < 5; j++) {
            int randNum = getRandomNum(redTemp, random);
            allNumbers[randNum].count++;
            if (lastList.contains(randNum)){
                countRed++;
            }
            result.add(randNum);
        }
//        System.out.println(countRed + "\t" + result);
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



