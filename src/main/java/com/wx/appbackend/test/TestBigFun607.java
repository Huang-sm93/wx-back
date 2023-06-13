package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFun607 {
    static List<Integer> initList;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> lastList = ReadExcelUtility.getBFRLastNumbers(0, 2000);

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            List<Integer> lastTime = lastList.get(i);
            int count = 0;
            Set<Integer> lastSet = new HashSet<>();
            for (int j = i+1; j <= i+4; j++) {
                lastSet.addAll(lastList.get(j));
            }
            List<Integer> canSelect = new ArrayList<>();
            for (int j = 1; j < 36; j++) {
                if (!lastSet.contains(j)){
                    canSelect.add(j);
                    if (lastTime.contains(j)){
                        count++;
                    }
                }
            }
            List<String> currentRes = new ArrayList<>();
            currentRes.add(lastTime.toString());
            currentRes.add(canSelect.toString());
            currentRes.add(""+count);
            res.add(currentRes);
        }
        WritableWorkbook book = null;
        if (res.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("统计607.xls" ));
                ReadExcelUtility.writeFile6(res, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

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
//
//        initList.add(6);
//        initList.add(8);
//        initList.add(22);
//        initList.add(24);
//        initList.add(30);


        initList.add(9);
        initList.add(15);
        initList.add(22);
        initList.add(26);
        initList.add(29);
//        initList.add(27);
//        initList.add(35);
    }
}

