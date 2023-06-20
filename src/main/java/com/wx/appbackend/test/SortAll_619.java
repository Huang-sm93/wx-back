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
public class SortAll_619 {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> lastList = ReadExcelUtility.getBFRLastNumbersAll2();
        CellNumber[] allRed = new CellNumber[36];
        CellNumber[] allBlue = new CellNumber[13];
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < lastList.size(); i++) {
            // 获取红色
            for (int j = 0; j < 12; j++) {
                int index = lastList.get(i).get(j);
                if (allRed[index] == null){
                    allRed[index] = new CellNumber(index, 0);
                }
                allRed[index].count = allRed[index].count + 1;
            }
            // 获取蓝色
            for (int j = 12; j < 15; j++) {
                int index = lastList.get(i).get(j);
                if (allBlue[index] == null){
                    allBlue[index] = new CellNumber(index, 0);
                }
                allBlue[index].count = allBlue[index].count + 1;
            }
        }
        List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
        List<CellNumber> blueList = Arrays.stream(allBlue).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
        List<Integer> mostRed = redList.subList(0,12).stream().map(o->o.number).collect(Collectors.toList());
        List<Integer> mostBlue = blueList.subList(0,3).stream().map(o->o.number).collect(Collectors.toList());
        List<Integer> lessRed = redList.subList(redList.size()-8,redList.size()).stream().map(o->o.number).collect(Collectors.toList());
        List<Integer> lessBlue =  blueList.subList(blueList.size()-3,blueList.size()).stream().map(o->o.number).collect(Collectors.toList());
        System.out.println("最多："+mostRed);
        System.out.println("最多："+mostBlue);
        System.out.println("最少："+lessRed);
        System.out.println("最少："+lessBlue);
        System.out.println("全："+redList.stream().map(o->o.number).collect(Collectors.toList()));
        System.out.println("全："+blueList.stream().map(o->o.number).collect(Collectors.toList()));
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(14);
        initListA.add(16);
        initListA.add(20);
        initListA.add(23);
        initListA.add(30);
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
        for (int j = 0; j < 6; j++) {
            result.add(getRandomNum(redTemp, random));
        }


        return result;
    }
}

