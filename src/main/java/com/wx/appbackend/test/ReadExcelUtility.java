package com.wx.appbackend.test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/11/7
 */
public class ReadExcelUtility {

    public static List<CellInfo> getArrFileName(String fileName){
        List<CellInfo> result = new ArrayList<>();
        if (StringUtils.isEmpty(fileName)){
            return null;
        }
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 1; i < sheet.getRows(); i++) {
                CellInfo cellInfo = new CellInfo();
                int[] temp = new int[7];
                int count = 0;
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(0, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(6, i).getContents());
                cellInfo.values = temp;
                cellInfo.countRedValues = Integer.parseInt(sheet.getCell(7, i).getContents());
                cellInfo.countAllValues = Integer.parseInt(sheet.getCell(8, i).getContents());
                cellInfo.date = sheet.getCell(9, i).getContents();
                result.add(cellInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<CellInfo> getArrFileName(String fileName, int usedTimes){
        List<CellInfo> result = new ArrayList<>();
        if (StringUtils.isEmpty(fileName)){
            return null;
        }
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 1; i <= usedTimes; i++) {
                CellInfo cellInfo = new CellInfo();
                int[] temp = new int[7];
                int count = 0;
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(0, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(6, i).getContents());
                cellInfo.values = temp;
                cellInfo.countRedValues = Integer.parseInt(sheet.getCell(7, i).getContents());
                cellInfo.countAllValues = Integer.parseInt(sheet.getCell(8, i).getContents());
                result.add(cellInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<CellInfo> getArrFileName(String fileName, int start, int usedTimes){
        List<CellInfo> result = new ArrayList<>();
        if (StringUtils.isEmpty(fileName)){
            return null;
        }
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            int maxLine = usedTimes < sheet.getRows() ? usedTimes : sheet.getRows();
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = start; i < maxLine; i++) {
                CellInfo cellInfo = new CellInfo();
                int[] temp = new int[7];
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(0, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(6, i).getContents());
                cellInfo.values = temp;
                cellInfo.countRedValues = Integer.parseInt(sheet.getCell(7, i).getContents());
                cellInfo.countAllValues = Integer.parseInt(sheet.getCell(8, i).getContents());
                cellInfo.date = sheet.getCell(9, i).getContents();
                result.add(cellInfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Set<Integer> getLastNumbers(int times){
        Set<Integer> result = new HashSet<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\历史记录.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 1; i <= times; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                result.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(4, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(5, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(6, i).getContents()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }


 public static Map<String, List<Integer>> getLastNumbers1(int times){
     List<Integer> redList = new ArrayList<>();
     List<Integer> blueList = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\历史记录.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 1; i <= times; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                redList.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                redList.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                redList.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                redList.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                redList.add(Integer.parseInt(sheet.getCell(4, i).getContents()));
                redList.add(Integer.parseInt(sheet.getCell(5, i).getContents()));
                blueList.add(Integer.parseInt(sheet.getCell(6, i).getContents()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("red", redList);
        result.put("blue", blueList);
        return result;
    }

    public static List<Integer> getLastNumber(){
     List<Integer> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\历史记录.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            result.add(Integer.parseInt(sheet.getCell(0, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(1, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(2, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(3, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(4, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(5, 0).getContents()));
            result.add(Integer.parseInt(sheet.getCell(6, 0).getContents()));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void writeFile(List<int[]> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        List<Integer> lastTime = ReadExcelUtility.getLastNumber();

            // 创建第一张工作表
                WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
                // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
                int index = 0;
                for (int i = 0; i < list.size(); i++) {

                    int[] temp = list.get(i);
                    int countRed = 0;
                    countRed = countRed + (lastTime.contains(temp[0]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[1]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[2]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[3]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[4]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[5]) ? 1 :0);
                    int countBlue = temp[6] == lastTime.get(6) ? 1 : 0;
                    int money = 0;
                    int sum = countBlue+countRed;
                    switch (sum){
                        case 7:
                            money=5000000;
                            break;
                        case 6:
                            money = countBlue == 1 ? 3000 : 200000;
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
                    if (money < 5){continue;}
                    // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                    Number number1 = new Number( 0 , index, temp[0]);
                    Number number2 = new Number( 1 , index, temp[1]);
                    Number number3 = new Number( 2 , index, temp[2]);
                    Number number4 = new Number( 3 , index, temp[3]);
                    Number number5 = new Number( 4 , index, temp[4]);
                    Number number6 = new Number( 5 , index, temp[5]);
                    Number number7 = new Number( 6 , index, temp[6]);
                    Number number8 = new Number( 7 , index, countRed);
                    Number number9 = new Number( 8 , index, countBlue);
                    Number number10 = new Number(9, index, money);
                    index++;
                    try {
                        sheet.addCell(number1);
                        sheet.addCell(number2);
                        sheet.addCell(number3);
                        sheet.addCell(number4);
                        sheet.addCell(number5);
                        sheet.addCell(number6);
                        sheet.addCell(number7);
                        sheet.addCell(number8);
                        sheet.addCell(number9);
                        sheet.addCell(number10);
                    } catch (WriteException e) {
                        throw new RuntimeException(e);
                    }
                }


    }

    public static void writeFile12(List<int[]> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {

            // 创建第一张工作表
                WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
                // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
                for (int i = 0; i < list.size(); i++) {
                    int[] temp = list.get(i);
                    // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                    Number number1 = new Number( 0 , i, temp[0]);
                    Number number2 = new Number( 1 , i, temp[1]);
                    Number number3 = new Number( 2 , i, temp[2]);
                    Number number4 = new Number( 3 , i, temp[3]);
                    Number number5 = new Number( 4 , i, temp[4]);
                    Number number6 = new Number( 5 , i, temp[5]);
                    Number number7 = new Number( 6 , i, temp[6]);
                    try {
                        sheet.addCell(number1);
                        sheet.addCell(number2);
                        sheet.addCell(number3);
                        sheet.addCell(number4);
                        sheet.addCell(number5);
                        sheet.addCell(number6);
                        sheet.addCell(number7);

                    } catch (WriteException e) {
                        throw new RuntimeException(e);
                    }
                }


    }

    public static void writeFile1(List<int[]> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        List<Integer> lastTime = ReadExcelUtility.getLastNumber();

            // 创建第一张工作表
                WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
                // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
                for (int i = 0; i < list.size(); i++) {
                    int[] temp = list.get(i);
                    // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                    Number number1 = new Number( 0 , i, temp[0]);
                    Number number2 = new Number( 1 , i, temp[1]);
                    Number number3 = new Number( 2 , i, temp[2]);
                    Number number4 = new Number( 3 , i, temp[3]);
                    Number number5 = new Number( 4 , i, temp[4]);
                    Number number6 = new Number( 5 , i, temp[5]);
                    Number number7 = new Number( 6 , i, temp[6]);
                    int countRed = 0;
                    countRed = countRed + (lastTime.contains(temp[0]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[1]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[2]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[3]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[4]) ? 1 :0);
                    countRed = countRed + (lastTime.contains(temp[5]) ? 1 :0);
                    Number number8 = new Number( 7 , i, countRed);
                    int countBlue = temp[6] == lastTime.get(6) ? 1 : 0;
                    Number number9 = new Number( 8 , i, countBlue);
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

                    Number number10 = new Number(9, i, money);
                    Number number11 = new Number(10, i, i);
                    Number number12 = new Number(11, i, temp[7]);

                    try {
                        sheet.addCell(number1);
                        sheet.addCell(number2);
                        sheet.addCell(number3);
                        sheet.addCell(number4);
                        sheet.addCell(number5);
                        sheet.addCell(number6);
                        sheet.addCell(number7);
                        sheet.addCell(number8);
                        sheet.addCell(number9);
                        sheet.addCell(number10);
                        sheet.addCell(number11);
                        sheet.addCell(number12);

                    } catch (WriteException e) {
                        throw new RuntimeException(e);
                    }
                }


    }

    public static List<Integer> hisList;
    static {
        hisList = new ArrayList<>();
        hisList.add(2);
        hisList.add(14);
        hisList.add(19);
        hisList.add(21);
        hisList.add(25);
        hisList.add(28);
    }

    public static List<int[]> getAllList() {
        List<int[]> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\历史记录.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                int[] temp = new int[7];
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(0, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(6, i).getContents());
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }
}
