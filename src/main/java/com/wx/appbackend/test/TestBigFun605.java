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
public class TestBigFun605 {

    static List<Integer> initList;

    public static void main(String[] args) {
        List<List<Integer>> lastList = ReadExcelUtility.getBFRLastNumbers(0, 2000);
        int start = 3;
        List<Integer> lasTime = lastList.get(start);
        for (int k = 20; k < 200; k++) {
            for (int i = start+1; i < 1800; i++) {
                List<List<Integer>> sub = lastList.subList(i, i+k);
                int count = test(initList, sub, i);
                if (count == 2){
                    System.out.println("位置"+i+"-"+(i+k)+"\t命中："+count);
                }
            }
        }

    }

    public static int test(List<Integer> lastTime, List<List<Integer>> lastList, int indexTimes) {

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
        int count = 0;
        for (int i = 0; i < 2; i++) {
            if (lastTime.contains(redList.get(i))){
                count++;
            }
        }
        if (count == 2){
            System.out.print(redList.subList(0, 5));
        }
        return count;


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
        initList.add(2);
        initList.add(10);
//        initList.add(18);
//        initList.add(25);
//        initList.add(32);
    }
}

