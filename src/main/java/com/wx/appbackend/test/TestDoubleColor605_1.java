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
public class TestDoubleColor605_1 {
    static List<Integer> initList;

    public static int getRandomNum(List<Integer> blueCount, Random random){

        int randNum = random.nextInt(blueCount.size());
        int count = blueCount.get(randNum);
        boolean flag = true;
        while (flag){
            flag = blueCount.remove(new Integer(count));
        }
        return count;
    }


    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers(0, 2000);
//        int index1 = 3;
//        List<Integer> current = lastList.get(index1);
//
//        CellNumber[] allRed = new CellNumber[34];
//        for (int i = 100+index1; i < 120+index1; i++) {
//            List<Integer> currentList = lastList.get(i);
//            for (int j = 0; j < currentList.size(); j++) {
//                int index = currentList.get(j);
//                if (allRed[index] == null){
//                    allRed[index] = new CellNumber(index, 0);
//                }
//                allRed[index].count = allRed[index].count + 1;
//            }
//        }
//        List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o->o.number).collect(Collectors.toList());
//        List<Integer> canSelectList = new ArrayList<>();
//        for (int i = 0; i < redList.size(); i++) {
//            for (int j = 0; j < (redList.size()*2-i*4); j++) {
//                canSelectList.add(redList.get(i));
//            }
//        }
//
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            Random random = new Random();
//            List<Integer> blueCount = new ArrayList<>(canSelectList);
//            List<Integer> currentRes = new ArrayList<>();
//            int count = 0;
//            for (int j = 0; j < 15; j++) {
//                int temp = getRandomNum(blueCount, random);
//                count = current.contains(temp) ? count+1 : count;
//                currentRes.add(temp);
//            }
//
//            List<Integer> blues = currentRes.subList(currentRes.size()-12, currentRes.size()-6);
//            blues.add(count);
//            res.add(blues);
//        }
//
//        WritableWorkbook book = null;
//        if (res.size() > 0){
//            try {
//                book = Workbook.createWorkbook( new File("统计606.xls" ));
//                ReadExcelUtility.writeFile5(res, book, 1);
//                book.write();
//            } catch (IOException | WriteException e) {
//                throw new RuntimeException(e);
//            }finally {
//                book.close();
//            }
//        }

        for (int i = 0; i < lastList.size(); i++) {
            int count = 0;
            for (int j = 0; j < initList.size(); j++) {
                if (lastList.get(i).contains(initList.get(j))){
                    count++;
                }
            }
            if (count >= 4){
                System.out.println(lastList.get(i)+"位置"+i+"命中："+count);
            }
        }

//        int start = 606;
//        int end = start + 20;
//        int current = 1;
//        test(lastList.get(current), lastList.subList(start, end), end);

    }

    public static void test(List<Integer> lastTime, List<List<Integer>> lastList, int indexTimes) {
//        System.out.println(lastTime);
        CellNumber[] allRed = new CellNumber[36];
        for (int i = 0; i < lastList.size(); i++) {
            List<Integer> currentList = lastList.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                int index = currentList.get(j);
                if (allRed[index] == null){
                    allRed[index] = new CellNumber(index, 0);
                }
                allRed[index].count = allRed[index].count + 1;
            }
        }

        List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o->o.number).collect(Collectors.toList());
        System.out.println(redList.subList(0,5));
        //        int count = 0;
//        for (int i = 0; i < 5; i++) {
//            if (lastTime.contains(redList.get(i))){
//                count++;
//            }
//        }
//        if (count > 2){
//            System.out.println("位置"+indexTimes+"命中："+count);
//            System.out.println(redList.subList(0, 5));
//        }


//        WritableWorkbook book = null;
//        if (resultList.size() > 0){
//            try {
//                book = Workbook.createWorkbook( new File("统计602.xls" ));
//                ReadExcelUtility.writeFile4(resultList, book, 1);
//                book.write();
//            } catch (IOException | WriteException e) {
//                throw new RuntimeException(e);
//            }finally {
//                book.close();
//            }
//        }

    }
    public static int isSame(List<Integer> list1) {
        boolean flag = false;
        int index = 0;
//        List<List<Integer>> list = ReadExcelUtility.getBFArrFileName1("D:\\Work\\wx-app-backend-master\\BF计算位置结果.xls", 0);
        List<Integer> lastTime =new ArrayList<>();
        lastTime.add(6);
        lastTime.add(7);
        lastTime.add(22);

        lastTime.add(24);
        lastTime.add(30);
//        for (int i = 0; i < list.size(); i++) {
        int count = 0;
        for (int j = 0; j < list1.size(); j++) {
            if (lastTime.contains(list1.get(j))) {
                count++;
            }
        }
        return count;
//            if (count >= 5) {
//                flag = true;
//                index = i;
//                break;
//            }
//        }
//        if (flag) {
//            return index;
//        } else {
//            return 0;
//        }
    }

    static {
        initList = new ArrayList<>();
//        initList.add(4);
//        initList.add(11);
//        initList.add(18);
//        initList.add(25);
//        initList.add(32);

//        initList.add(2);
//        initList.add(10);
//        initList.add(18);
//        initList.add(25);
//        initList.add(33);


        initList.add(1);
        initList.add(7);
        initList.add(11);
        initList.add(12);
        initList.add(18);
        initList.add(16);

    }
}

