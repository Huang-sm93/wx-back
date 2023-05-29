package com.wx.appbackend.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestMALL {
    public static void main(String[] args) throws WriteException, IOException {
        long[] allIndex = {1002254, 19629391, 12296069, 21122429, 538976};
        List<Integer> redAll = new ArrayList<>();
        redAll.add(2);
        redAll.add(6);
        redAll.add(13);
        redAll.add(22);
        redAll.add(27);
        redAll.add(32);
        int blue = 6;
        Workbook workbook = null;
        WritableWorkbook writableWorkbook = null;
        try {
            // 解析路径的file文件
            workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\预测.xls"));
            writableWorkbook = Workbook.createWorkbook( new File("预测结果3.xls" ));
            WritableSheet writableSheet = writableWorkbook.createSheet( " 第"+1+"页 " , 0);
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            CellNumber[] allRed = new CellNumber[34];
            CellNumber[] allBlue = new CellNumber[17];
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

            int size = 18;
            int countRed = 0;
            for (int i = 0; i < size; i++) {
                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
                System.out.print("\t"+redList.get(i).number);
            }
//            for (int i = redList.size()-size; i < redList.size(); i++) {
//                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
//                System.out.print("\t"+redList.get(i).number);
//            }
            System.out.println("红球中奖个数："+countRed);
            for (int i = 0; i < blueList.size(); i++) {
                System.out.print("\t" + blueList.get(i).number);
            }
            int countBlue = blueList.get(0).number == blue ||
                    blueList.get(1).number == blue ||
                    blueList.get(2).number == blue ||
                    blueList.get(3).number == blue ||
                    blueList.get(4).number == blue
                    ? 1 : 0;
                int money = 0;
                int sum = countBlue+countRed;
                switch (sum){
                    case 7:
                        money=5000000;
                        break;
                    case 6:
                        money= countBlue==1 ? 3000 : 300000;
                        break;
                    case 5:
                        money=200;
                        break;
                    case 4:
                        money=10;
                        break;
                    default:
                        money = countBlue == 1 ? 5 : 0;
                        break;
                }

//                Number number1 = new Number( 0 , i, temp[0]);
//                Number number2 = new Number( 1 , i, temp[1]);
//                Number number3 = new Number( 2 , i, temp[2]);
//                Number number4 = new Number( 3 , i, temp[3]);
//                Number number5 = new Number( 4 , i, temp[4]);
//                Number number6 = new Number( 5 , i, temp[5]);
//                Number number7 = new Number( 6 , i, temp[6]);
//                Number number8 = new Number( 7 , i, money);
//                try {
//                    writableSheet.addCell(number1);
//                    writableSheet.addCell(number2);
//                    writableSheet.addCell(number3);
//                    writableSheet.addCell(number4);
//                    writableSheet.addCell(number5);
//                    writableSheet.addCell(number6);
//                    writableSheet.addCell(number7);
//                    writableSheet.addCell(number8);
//
//                } catch (WriteException e) {
//                    throw new RuntimeException(e);
//                }

//            writableWorkbook.write();
            System.out.println("money = " + money);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }finally {
            if (writableWorkbook != null) {
                writableWorkbook.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        }
    }
}
