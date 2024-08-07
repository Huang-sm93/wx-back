package com.wx.appbackend.study;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.*;
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

    public static List<int[]> getBFArrFileName(String fileName, int usedTimes){
        List<int[]> result = new ArrayList<>();
        if (StringUtils.isEmpty(fileName)){
            return null;
        }
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                int[] temp = new int[7];
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(6, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(7, i).getContents());

                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<int[]> getDCArrFileName(String fileName){
        List<int[]> result = new ArrayList<>();
        if (StringUtils.isEmpty(fileName)){
            return null;
        }
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                int[] temp = new int[7];
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp[0] = Integer.parseInt(sheet.getCell(1, i).getContents());
                temp[1] = Integer.parseInt(sheet.getCell(2, i).getContents());
                temp[2] = Integer.parseInt(sheet.getCell(3, i).getContents());
                temp[3] = Integer.parseInt(sheet.getCell(4, i).getContents());
                temp[4] = Integer.parseInt(sheet.getCell(5, i).getContents());
                temp[5] = Integer.parseInt(sheet.getCell(6, i).getContents());
                temp[6] = Integer.parseInt(sheet.getCell(7, i).getContents());

                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static List<List<Integer>> getBFArrFileName1(String fileName, int usedTimes){
        List<List<Integer>> result = new ArrayList<>();
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
            for (int i = 0; i < sheet.getRows(); i++) {
                List<Integer> temp = new ArrayList<>();
                int count = 0;
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                temp.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(4, i).getContents()));

                result.add(temp);
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

    public static List<List<Integer>> getBFRLastNumbers(int startTimes, int endTimes){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\BF记录925.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = startTimes; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(4, i).getContents()));
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFRLastNumbersAll2(){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\dalttou72.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getDCRLastNumbersAll2(){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\统计626-1.xls"));
            // 获取第一张工作表多数预测68
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 6; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<List<Integer>> getLastNumbersAll(String fileName){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表多数预测68
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 1; j < 8; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getLastNumbersBFRAll(String fileName){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表多数预测68
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 2; j < 5; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<String>> getDCRLastNumbers1(){
        List<List<String>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\多预测.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    temp.add(sheet.getCell(j, i).getContents());
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static List<List<Integer>> getDCRLastNumbers2(int index){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\dalttou%s.xls", index)));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
//            int count = sheet.getRows() > 1000 ? 1000 : sheet.getRows();
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < 400; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<List<Integer>> getDCRLastNumbers(int startTimes, int endTimes){
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\6月13历史记录.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = startTimes; i <= endTimes; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(4, i).getContents()));
                temp.add(Integer.parseInt(sheet.getCell(5, i).getContents()));
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Integer> getBFLastRedNumbers(String fileName, int start, int end){
        List<Integer> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = start; i <= end; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                result.add(Integer.parseInt(sheet.getCell(0, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(1, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(2, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(3, i).getContents()));
                result.add(Integer.parseInt(sheet.getCell(4, i).getContents()));

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
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\近100次历史记录.xls"));
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
//                    if (money < 5){continue;}
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

    public static void writeFile(List<List<Integer>> list, WritableWorkbook book, int selectRed, int selectBlue) throws WriteException, IOException {
        List<Integer> lastTime = ReadExcelUtility.getLastNumber();
        int blue = lastTime.get(6);
        lastTime.remove(lastTime.size()-1);
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第一页 " , 0);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        int index = 0;
        for (int i = 0; i < list.size(); i++) {

            List<Integer> temp = list.get(i);
            int countRed = 0;
            for (int j = 0; j < temp.size()-selectBlue; j++) {
                countRed = countRed + (lastTime.contains(temp.get(j)) ? 1 :0);
            }
            int countBlue = 0;
            for (int j = temp.size()-selectBlue; j < temp.size(); j++) {
                countBlue = countBlue + blue==temp.get(j) ? 1 :0;
            }

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
//                    if (money < 5){continue;}
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int j = 0; j < temp.size(); j++) {
                Number number = new Number( j , index, temp.get(j));
                sheet.addCell(number);
            }
            Number number1 = new Number(temp.size(), index, money);
            sheet.addCell(number1);
            index++;
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

    public static void writeFile2(List<int[]> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            for (int j = 0; j < temp.length; j++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                Number number1 = new Number( j , i, temp[j]);
                sheet.addCell(number1);
            }
        }


    }

    public static void writeFile2(int[] temp, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始

            for (int j = 1; j < temp.length; j++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                Number number1 = new Number( 0 , j-1, j);
                Number number2 = new Number( 1 , j-1, temp[j]);
                sheet.addCell(number1);
                sheet.addCell(number2);
            }



    }


    public static void writeFile3(List<String[]> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i);
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int j = 0; j < temp.length; j++) {
                Label number1 = new Label(j, i, temp[j]);
                try {
                    sheet.addCell(number1);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void writeFile6(List<List<String>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            List<String> temp = list.get(i);
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int j = 0; j < temp.size(); j++) {
                Label number1 = new Label(j, i, temp.get(j));
                try {
                    sheet.addCell(number1);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void writeFile4(List<List<Integer>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int j = 0; j < temp.size(); j++) {
                Number number1 = new Number(j, i, temp.get(j));
                try {
                    sheet.addCell(number1);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void writeFile5(List<List<Integer>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
            for (int j = 0; j < temp.size(); j++) {
                Number number1 = new Number(j, i, temp.get(j));
                try {
                    sheet.addCell(number1);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


 public static void writeFile03(List<CellNumber> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            CellNumber temp = list.get(i);
            Number number1 = new Number(0, i, temp.number);
            Number number2 = new Number(1, i, temp.count);
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
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

    /**
     * 计算金额
     * @param redAll
     * @param blue
     * @throws WriteException
     * @throws IOException
     */
    public static void calculatePrize(List<Integer> redAll, int blue) throws WriteException, IOException {
        Workbook workbook = null;
        WritableWorkbook writableWorkbook = null;
        try {
            // 解析路径的file文件
            workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\预测.xls"));
            writableWorkbook = Workbook.createWorkbook( new File("预测结果3.xls" ));
            WritableSheet writableSheet = writableWorkbook.createSheet( " 第"+1+"页 " , 0);
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
                int countRed = 0;
                countRed = countRed + (redAll.contains(temp[0]) ? 1 :0);
                countRed = countRed + (redAll.contains(temp[1]) ? 1 :0);
                countRed = countRed + (redAll.contains(temp[2]) ? 1 :0);
                countRed = countRed + (redAll.contains(temp[3]) ? 1 :0);
                countRed = countRed + (redAll.contains(temp[4]) ? 1 :0);
                countRed = countRed + (redAll.contains(temp[5]) ? 1 :0);
                int countBlue = temp[6] == blue ? 1 : 0;
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

                Number number1 = new Number( 0 , i, temp[0]);
                Number number2 = new Number( 1 , i, temp[1]);
                Number number3 = new Number( 2 , i, temp[2]);
                Number number4 = new Number( 3 , i, temp[3]);
                Number number5 = new Number( 4 , i, temp[4]);
                Number number6 = new Number( 5 , i, temp[5]);
                Number number7 = new Number( 6 , i, temp[6]);
                Number number8 = new Number( 7 , i, money);
                try {
                    writableSheet.addCell(number1);
                    writableSheet.addCell(number2);
                    writableSheet.addCell(number3);
                    writableSheet.addCell(number4);
                    writableSheet.addCell(number5);
                    writableSheet.addCell(number6);
                    writableSheet.addCell(number7);
                    writableSheet.addCell(number8);

                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
            writableWorkbook.write();
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

    public static List<List<String>> getBFRLastNumbers1() {
        List<List<String>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\BF多预测.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < 17; j++) {
                    temp.add(sheet.getCell(j, i).getContents());
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getDCRLastNumbers21(int index) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\ssq125.xls")));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 12; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFLastNumbersAll(String date) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\BF%s记录.xls", date)));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 2; j < 7; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getDCLastNumbersAll(String date) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\ssq%s.xls", date)));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 2; j < 8; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<Long> getDCLastNumbersAll1() {
        List<Long> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\ssq位置.xls"));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                result.add(Long.parseLong(sheet.getCell(7, i).getContents()));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<List<Integer>> getDCLastNumbersBlue(String date) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\ssq%s.xls", date)));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 8; j < 9; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFBlueLastNumbersAll(String date) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\BF%s记录.xls", date)));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 7; j < 9; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFLastRedNumbersAll() {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\BF2记录.xls")));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 1; j < 6; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFLastRedNumbersIndexAll() {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\ssq位置.xls")));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 1; j < 7; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<List<Integer>> getBFLastNumbersOther() {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(String.format("D:\\Work\\wx-app-backend-master\\dalttou111.xls")));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < sheet.getRows(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 15; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void writeFile8(List<List<CellNumber>> list,  WritableWorkbook book, int sheetNum) {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                CellNumber temp = list.get(i).get(j);
                Number number1 = new Number(i, j, temp.number);

                if (temp.isTrue == 1) {
                    number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                            WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
                }
                try {
                    sheet.addCell(number1);

                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public static void writeFile8Sheet2(List<List<CellNumber>> list,  WritableWorkbook book, int sheetNum) {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                CellNumber temp = list.get(i).get(j);
                Number number1 = new Number(i*3+0, j, temp.number);
                Number number2 = new Number(i*3+1, j, temp.count);
                if (temp.isTrue == 1) {
                    number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                            WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
                    number2.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                            WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
                }
                try {
                    sheet.addCell(number1);
                    sheet.addCell(number2);

                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    public static void writeFile18(List<Long> list, WritableWorkbook book, int sheetNum) {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for (int i = 0; i < list.size(); i++) {
                long temp = list.get(i);
                Number number0 = new Number(0, i, temp);
            try {
                sheet.addCell(number0);
                for (int j = 1; j < 21; j++) {
                    Number number1 = new Number(j, i, temp % (j*4));
                    sheet.addCell(number1);
                }
            } catch (WriteException e) {
                    throw new RuntimeException(e);
                }
            }
    }

    public static List<List<Integer>> getBF(int size, String name) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(name));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            int maxSize = size > sheet.getRows() ? sheet.getRows() : size;
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < maxSize; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                if (Integer.parseInt(sheet.getCell(5, i).getContents()) > 3){
                    continue;
                }
                List<Integer> temp = new ArrayList<>();
                for (int j = 2; j < 5; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static List<List<Integer>> getBFBLUE(int size, String name) {
        List<List<Integer>> result = new ArrayList<>();
        try {
            // 解析路径的file文件
            Workbook workbook = Workbook.getWorkbook(new File(name));
            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            int maxSize = size > sheet.getRows() ? sheet.getRows() : size;
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < maxSize; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                List<Integer> temp = new ArrayList<>();
                for (int j = 2; j < 3; j++) {
                    temp.add(Integer.parseInt(sheet.getCell(j, i).getContents()));
                }
                result.add(temp);
            }

        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void writeFileSSQRed(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (ssqRedLastList.get(j).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }
    public static void writeFileSSQRed(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum, List<List<Integer>> lastList) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (lastList.get(j).subList(0,6).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }


    public static void writeFileSSQBlue(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (ssqBlueLastList.get(j).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }


    public static void writeFileBFBlue(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (bfBlueLastList.get(j).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }


    public static void writeFileBFRed(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (bfRedLastList.get(j).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }

    public static void writeFileBFRed(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum, List<List<Integer>> curList) throws WriteException, IOException {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

        for (int i = 0; i < list.get(j).size(); i++) {
            CellNumber temp = list.get(j).get(i);
            Number number1 = new Number(j*3 , i, temp.number);
            Number number2 = new Number(j*3+1, i, temp.count);
            if (curList.get(j).contains(temp.number)) {
                number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10,
                        WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
            }
            try {
                sheet.addCell(number1);
                sheet.addCell(number2);
            } catch (WriteException e) {
                throw new RuntimeException(e);
            }

        }
        }
    }

    // 近几次的结果list静态变量
    public static List<List<Integer>> ssqRedLastList;
    public static List<List<Integer>> ssqBlueLastList;
    public static List<List<Integer>> bfBlueLastList;
    public static List<List<Integer>> bfRedLastList;

    static {
        ssqRedLastList = new ArrayList<>();
        ssqBlueLastList = new ArrayList<>();
        bfBlueLastList = new ArrayList<>();
        bfRedLastList = new ArrayList<>();
        // 024 bfb
        bfBlueLastList.add(Arrays.asList(2,12));
        // 025 bfb
        bfBlueLastList.add(Arrays.asList(4,8));
        // 026 bfb
        bfBlueLastList.add(Arrays.asList(1,12));
        // 027 bfb
        bfBlueLastList.add(Arrays.asList(4,5));
        // 028 bfb
        bfBlueLastList.add(Arrays.asList(0));

        // 024 bfr
        bfRedLastList.add(Arrays.asList(3, 5, 12, 17, 26));
        // 025 bfr
        bfRedLastList.add(Arrays.asList(1,2,8,18,27));
        // 026 bfr
        bfRedLastList.add(Arrays.asList(1,18,21,26,33));
        // 027 bfr
        bfRedLastList.add(Arrays.asList(4,19,24,28,34));
        // 028 bfr
        bfRedLastList.add(Arrays.asList(0));

        //023
        ssqRedLastList.add(Arrays.asList(1, 10, 22, 25, 28, 32));
        // 024
        ssqRedLastList.add(Arrays.asList(3,7,21,24,26,30));
        // 025
        ssqRedLastList.add(Arrays.asList(8,15,21,22,25,33));
        // 026
        ssqRedLastList.add(Arrays.asList(4,7,18,19,20,25));
        // 027
        ssqRedLastList.add(Arrays.asList(0));

        //023
        ssqBlueLastList.add(Arrays.asList(10));
        // 024
        ssqBlueLastList.add(Arrays.asList(10));
        // 025
        ssqBlueLastList.add(Arrays.asList(13));
        // 026
        ssqBlueLastList.add(Arrays.asList(6));
        // 027
        ssqBlueLastList.add(Arrays.asList(0));
    }

    public static void writeFileBFRed1(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum, List<List<Integer>> lastList) {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        List<List<Integer>> lastList1 = new ArrayList<>();
        lastList1.add(Arrays.asList(0,0,0,0,0));
        lastList1.addAll(lastList);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

            for (int i = 0; i < list.get(j).size(); i++) {
                CellNumber temp = list.get(j).get(i);
                Number number1 = new Number(j*3 , i, temp.number);
                Number number2 = new Number(j*3+1, i, temp.count);
                if (lastList1.get(j).subList(0,5).contains(temp.number)) {
                    number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 12,
                            WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
                }
                try {
                    sheet.addCell(number1);
                    sheet.addCell(number2);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
    public static void writeFileBFBlue1(List<List<CellNumber>> list, WritableWorkbook book, int sheetNum, List<List<Integer>> lastList) {
        // 创建第一张工作表
        WritableSheet sheet = book.createSheet( " 第"+sheetNum+"页 " , sheetNum);
        List<List<Integer>> lastList1 = new ArrayList<>();
        lastList1.add(Arrays.asList(0,0,0,0,0,0,0,0));
        lastList1.addAll(lastList);
        // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
        for(int j = 0; j < list.size(); j++) {

            for (int i = 0; i < list.get(j).size(); i++) {
                CellNumber temp = list.get(j).get(i);
                Number number1 = new Number(j*3 , i, temp.number);
                Number number2 = new Number(j*3+1, i, temp.count);
                if (lastList1.get(j).subList(5,7).contains(temp.number)) {
                    number1.setCellFormat(new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 12,
                            WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.BLUE)));
                }
                try {
                    sheet.addCell(number1);
                    sheet.addCell(number2);
                } catch (WriteException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
