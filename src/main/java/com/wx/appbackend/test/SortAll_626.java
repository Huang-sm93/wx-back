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
public class SortAll_626 {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbersAll2();

//        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers2(index);

        List<List<Integer>> historyRed = new ArrayList<>();
        for (List<Integer> list : lastList) {
            int count = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                res.add(list.get(i));
                if (initListA.contains(list.get(i))){
                    count++;
                }
            }
            res.add(count);
            historyRed.add(res);
        }

        WritableWorkbook book = null;
        if (historyRed.size() > 0){
            try {
                book = Workbook.createWorkbook( new File(String.format("统计命中%s.xls" ,1)));
                ReadExcelUtility.writeFile4(historyRed, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }


//        CellNumber[] allRed = new CellNumber[34];
//        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
//        for (int i = 0; i < lastList.size(); i++) {
//            // 获取红色
//            for (int j = 0; j < 6; j++) {
//                int index = lastList.get(i).get(j);
//                if (allRed[index] == null){
//                    allRed[index] = new CellNumber(index, 0);
//                }
//                allRed[index].count = allRed[index].count + 1;
//            }
//        }
//        List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
//        System.out.println(redList.stream().map(o->o.number).collect(Collectors.toList()));
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(2);
        initListA.add(6);
        initListA.add(25);
        initListA.add(33);
        initListA.add(10);
        initListA.add(24);
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

