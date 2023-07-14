package com.wx.appbackend.test;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class DCUtility {

    static List<Integer> initListA;

    public static List<List<Integer>> calculate(List<List<Integer>> canSelect, int num1, int num2) throws WriteException, IOException {
        if (canSelect == null || canSelect.size() == 0) {
            return null;
        }
        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers2(72);
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < canSelect.size(); i++) {

            List<Integer> lastRedList = canSelect.get(i);
            int times1 = 0;
            int times2 = 0;
            for (List<Integer> integers : lastList) {
                int count = 0;
                List<Integer> temp = integers.subList(0,12);
                for (int j = 0; j < lastRedList.size(); j++) {
                    if (temp.contains(lastRedList.get(j))){
                        count++;
                    }
                }
                if (count == 6 ){
                    if (times1 < num1){
                        times1++;
                    }else {
                        flag = false;
                        break;
                    }
                }
                if (count == 5){
                    if (times2 < num2){
                        times2++;
                    }else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag){
                System.out.println("第" + i + "次");
                System.out.println(lastRedList);
                res.add(lastRedList);
            }
        }

        return res;
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(2);
        initListA.add(6);
        initListA.add(10);
        initListA.add(24);
        initListA.add(25);
        initListA.add(33);
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

