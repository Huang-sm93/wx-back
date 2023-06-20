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
public class TestDoubleEnableNumbers1 {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<Integer> allRed = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            allRed.add(i);
        }
        List<Integer> res =  getResult(allRed);
        System.out.println(res);
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(2);
        initListA.add(7);
        initListA.add(8);
        initListA.add(10);
        initListA.add(26);
        initListA.add(31);
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
        for (int j = 0; j < 9; j++) {
            result.add(getRandomNum(redTemp, random));
        }

        return result;
    }
}

