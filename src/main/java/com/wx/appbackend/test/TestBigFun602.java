package com.wx.appbackend.test;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestBigFun602 {

    public static void main(String[] args) throws WriteException, IOException {
        long maxSize = 324632L;
        //计算时间
        long time = 2023*5*29*21*15;
//        System.out.println(time);
        long allNumbers = Long.parseLong("27192430");
        long times = Long.parseLong("20230529211600");
        long allNumberMup = 2*7*19*24*30;
        int index = 66201;
        System.out.println(time%maxSize);
        System.out.println((time&allNumbers)%maxSize);
        System.out.println((time&allNumberMup)%maxSize);
        System.out.println((times&allNumberMup)%maxSize);
        System.out.println(times%maxSize);


        for (int i = 0; i < 10000000; i++) {
            if ((maxSize*i+index)%29 == 0){
                long constantValue = (maxSize*i+index)/ 29;
                if (constantValue*27 == 251265){
                    System.out.println("yes:"+i);
                }

            }
//            else {
//                System.out.println("no:"+i);
//            }
        }
//        List<Integer> initList = new ArrayList<>();
//        initList.add(4);
//        initList.add(11);
//        initList.add(18);
//        initList.add(25);
//        initList.add(32);
//        List<List<Integer>> resultList = new ArrayList<>();
//        List<Integer> disableList = new ArrayList<>();
//        disableList.add(7);
//        for (int i = 0; i < 1000; i++) {
//            List<Integer> temp = new ArrayList<>();
//            Random random = new Random();
//            for (int j = 0; j < 5; j++) {
//                temp.add(initList.get(j) -3 + random.nextInt(7));
//            }
//            //额外增加两个数
//            boolean flag1 = true;
//            while (flag1){
//                int number1 = random.nextInt(12)+1;
//                if (!temp.contains(number1)){
//                    temp.add(number1);
//                    flag1 = false;
//                }
//            }
//            boolean flag2 = true;
//            while (flag2){
//                int number2 = random.nextInt(12)+13;
//                if (!temp.contains(number2)){
//                    temp.add(number2);
//                    flag2 = false;
//                }
//            }
//            boolean flag3 = true;
//            while (flag3){
//                int number3 = random.nextInt(11)+25;
//                if (!temp.contains(number3)){
//                    temp.add(number3);
//                    flag3 = false;
//                }
//            }
//
//            resultList.add(temp);
//        }
//
//        for (int i = 0; i < resultList.size(); i++) {
//            resultList.get(i).add(i);
//            resultList.get(i).add(isSame(resultList.get(i)));
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
}

