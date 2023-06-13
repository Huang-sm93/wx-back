package com.wx.appbackend.test;

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
public class TestDoubleEnableNumbers {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<String>> lastList = ReadExcelUtility.getDCRLastNumbers1();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            res.add(i);
        }

//        for (int k = 0; k < 10000; k++) {
//            boolean flag = true;
//            List<Integer> randomList = getResult(new ArrayList<>(res));
            for (int i = 0; i < lastList.size(); i++) {
                int count = 0;
                List<String> current= lastList.get(i);
                List<Integer> currentList = new ArrayList<>();
                for (int j = 0; j < 12; j++) {
                    int number = Integer.parseInt(current.get(j));
                    currentList.add(number);
                    if (initListA.contains(number)){
                        count++;
                    }
                }
                System.out.println(current.get(17)+ currentList+"命中："+count);
//                int min = Integer.parseInt(current.get(12));
//                int max = Integer.parseInt(current.get(13));
//
//                if (count < min || count > max){
//                    flag = false;8
//                    break;
//                }

            }
//            if (flag){
//                randomList.sort((o1,o2)->o1-o2);
//                System.out.println(randomList);
//            }

//        }
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(2);
        initListA.add(14);
        initListA.add(17);
        initListA.add(20);
        initListA.add(26);
        initListA.add(33);
//        initListA.add(3);
//        initListA.add(14);
//        initListA.add(16);
//        initListA.add(19);
//        initListA.add(20);
//        initListA.add(23);
//        initListA.add(30);
//        initListA.add(31);
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

    public static List<Integer> getResult(List<Integer> allRed){
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        List<Integer> redTemp = new ArrayList<>(allRed);
        for (int j = 0; j < 6; j++) {
            result.add(getRandomNum(redTemp, random));
        }


        return result;
    }
}

