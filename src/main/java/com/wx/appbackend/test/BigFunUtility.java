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
public class BigFunUtility {

    static List<Integer> initListA;

    public static List<List<Integer>> calculate(List<List<Integer>> canSelect, int num1, int num2) throws WriteException, IOException {
        if (canSelect == null || canSelect.size() == 0) {
            return null;
        }
        List<List<Integer>> lastList = ReadExcelUtility.getBFRLastNumbersAll2();

//        List<Integer> reds = new ArrayList<>();
//        for (int i = 1; i < 34; i++) {
//            reds.add(i);
//        }
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
                if (count > 4 ){
                    if (times1 < num1){
                        times1++;
                    }else {
                        flag = false;
                        break;
                    }
                }
                if (count > 3){
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
//        CellNumber[] allRed = new CellNumber[34];
//        CellNumber[] allBlue = new CellNumber[17];
//        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
//        for (int i = 0; i < lastList.size(); i++) {
//            // 获取红色
//            for (int j = 0; j < 12; j++) {
//                int index = lastList.get(i).get(j);
//                if (allRed[index] == null){
//                    allRed[index] = new CellNumber(index, 0);
//                }
//                allRed[index].count = allRed[index].count + 1;
//            }
//            // 获取蓝色
//            for (int j = 12; j < 14; j++) {
//                int index = lastList.get(i).get(j);
//                if (allBlue[index] == null){
//                    allBlue[index] = new CellNumber(index, 0);
//                }
//                allBlue[index].count = allBlue[index].count + 1;
//            }
//        }
//        List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
//        List<CellNumber> blueList = Arrays.stream(allBlue).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
//        int i=1;
//        for (CellNumber cellNumber : redList) {
//            System.out.println(i++ + " " +cellNumber.number + " " + cellNumber.count);
//        }
//        int j=1;
//        System.out.println("====================================");
//        for (CellNumber cellNumber : blueList) {
//            System.out.println(j++ + " " +cellNumber.number + " " + cellNumber.count);
//        }
//        List<Integer> mostRed = redList.subList(0,12).stream().map(o->o.number).collect(Collectors.toList());
//        List<Integer> mostBlue = blueList.subList(0,3).stream().map(o->o.number).collect(Collectors.toList());
//        List<Integer> lessRed = redList.subList(redList.size()-8,redList.size()).stream().map(o->o.number).collect(Collectors.toList());
//        List<Integer> lessBlue =  blueList.subList(blueList.size()-3,blueList.size()).stream().map(o->o.number).collect(Collectors.toList());
//        System.out.println("最多："+mostRed);
//        System.out.println("最多："+mostBlue);
//        System.out.println("最少："+lessRed);
//        System.out.println("最少："+lessBlue);
//        System.out.println("全："+redList.stream().map(o->o.number).collect(Collectors.toList()));
//        System.out.println("全："+blueList.stream().map(o->o.number).collect(Collectors.toList()));
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
