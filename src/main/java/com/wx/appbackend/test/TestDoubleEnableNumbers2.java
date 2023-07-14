package com.wx.appbackend.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
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
public class TestDoubleEnableNumbers2 {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> resRList = new ArrayList<>();
        List<List<Integer>> resBList = new ArrayList<>();
        for (int l = 67; l < 75; l++) {
            List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers2(l);
            CellNumber[] allRed = new CellNumber[36];
            CellNumber[] blue = new CellNumber[13];

            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < lastList.size(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int j = 0; j < 12; j++) {
                    int index = lastList.get(i).get(j);
                    if (allRed[index] == null){
                        allRed[index] = new CellNumber(index, 0);
                    }
                    allRed[index].count = allRed[index].count + 1;
                }

                for (int j = 12; j < 15; j++) {
                    int index = lastList.get(i).get(j);
                    if (blue[index] == null){
                        blue[index] = new CellNumber(index, 0);
                    }
                    blue[index].count = blue[index].count + 1;
                }

            }
            List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o -> o.number).collect(Collectors.toList());
            List<Integer> blueList = Arrays.stream(blue).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o -> o.number).collect(Collectors.toList());
            redList.add(l);
            blueList.add(l);
            resRList.add(redList);
            resBList.add(blueList);
        }

        WritableWorkbook book = null;
        if (resRList.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("统计74-400.xls" ));
                ReadExcelUtility.writeFile5(resRList, book, 1);
                ReadExcelUtility.writeFile5(resBList, book, 2);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

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
        for (int j = 0; j < 6; j++) {
            result.add(getRandomNum(redTemp, random));
        }

        return result;
    }
}

