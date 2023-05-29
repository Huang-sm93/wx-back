package com.wx.appbackend.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
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
public class TestBigFun {
    public static String test() throws WriteException, IOException {
        long[] allIndex = {21088691,1002254, 19629391, 12296069, 21122429, 538976};
        List<Integer> redAll = new ArrayList<>();
        List<Integer> blueAll = new ArrayList<>();
//        redAll.add(1);
//        redAll.add(5);
//        redAll.add(6);
//        redAll.add(19);
//        redAll.add(24);
//        blueAll.add(5);
//        blueAll.add(11);

//        redAll.add(19);
//        redAll.add(22);
//        redAll.add(29);
//        redAll.add(32);
//        redAll.add(35);
//        blueAll.add(5);
//        blueAll.add(8);

        redAll.add(9);
        redAll.add(13);
        redAll.add(23);
        redAll.add(25);
        redAll.add(28);
        blueAll.add(4);
        blueAll.add(7);
        System.out.println("redAll:" + redAll);
        StringBuffer bf = new StringBuffer();
        bf.append("redAll:" + redAll + "\n");
        Workbook workbook = null;
        try {
            // 解析路径的file文件
            workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\预测daletou.xls"));

            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            CellNumber[] allRed = new CellNumber[36];
            CellNumber[] allBlue = new CellNumber[13];
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int j = 0; j < 6; j++) {
                    int index = Integer.parseInt(sheet.getCell(j, i).getContents());
                    if (allRed[index] == null){
                        allRed[index] = new CellNumber(index, 0);
                    }
                    allRed[index].count = allRed[index].count + 1;
                }

                int index1 = Integer.parseInt(sheet.getCell(6, i).getContents());
                if (allBlue[index1] == null){
                    allBlue[index1] = new CellNumber(index1, 0);
                }
                allBlue[index1].count = allBlue[index1].count + 1;
            }
            List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
            List<CellNumber> blueList = Arrays.stream(allBlue).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());

            int sizeLeft = 8;
            int sizeRight = 6;

            int blueSize = 8;
            int countRed = 0;
            int countBlue = 0;
//            List<CellNumber> redList1 = redList.subList(0,6);
//            List<CellNumber> redList2 = redList.subList(6,12);
//            List<CellNumber> redList3 = redList.subList(10,redList.size());
//            Random random = new Random();
//            Set<Integer> redSet1 = new HashSet<>();
//            for (int i = 0; i <4; i++) {
//                int index = random.nextInt(redList1.size()-1);
//                while (redSet1.contains(index)){
//                    index = random.nextInt(redList1.size()-1);
//                }
//                countRed = redAll.contains(redList1.get(index).number) ? countRed+1 : countRed;
//                System.out.print("\t"+redList1.get(index).number);
//                bf.append("\t"+redList1.get(index).number);
//            }
//
//            Set<Integer> redSet2 = new HashSet<>();
//            for (int i = 0; i <3; i++) {
//                int index = random.nextInt(redList2.size()-1);
//                while (redSet2.contains(index)){
//                    index = random.nextInt(redList2.size()-1);
//                }
//                redSet2.add(index);
//                countRed = redAll.contains(redList2.get(index).number) ? countRed+1 : countRed;
//                System.out.print("\t"+redList2.get(index).number);
//                bf.append("\t"+redList2.get(index).number);
//            }
//
//            Set<Integer> redSet3 = new HashSet<>();
//            for (int i = 0; i <2; i++) {
//                int index = random.nextInt(redList3.size()-1);
//                while (redSet3.contains(index)){
//                    index = random.nextInt(redList3.size()-1);
//                }
//                redSet3.add(index);
//                countRed = redAll.contains(redList3.get(index).number) ? countRed+1 : countRed;
//                System.out.print("\t"+redList3.get(index).number);
//                bf.append("\t"+redList3.get(index).number);
//            }
            for (int i = 0; i <sizeLeft; i++) {
                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
                System.out.print("\t"+redList.get(i).number);
                bf.append("\t"+redList.get(i).number);
            }
            for (int i = redList.size()/2; i < redList.size()/2 + sizeRight; i++) {
                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
                System.out.print("\t"+redList.get(i).number);
                bf.append("\t"+redList.get(i).number);
            }
            System.out.println("红球中奖个数："+countRed);
            bf.append("\n"+"红球中奖个数："+countRed + "\n");
            for (int i = 0; i < blueSize; i++) {
                countBlue = blueAll.contains(blueList.get(i).number) ? countBlue+1 : countBlue;
                System.out.print("\t"+blueList.get(i).number);
                bf.append("\t"+blueList.get(i).number);
            }
            System.out.println("蓝球中奖个数："+countBlue);
            bf.append("蓝球中奖个数："+countBlue);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }finally {

            if (workbook != null) {
                workbook.close();
            }
        }
        return bf.toString();
    }
}

