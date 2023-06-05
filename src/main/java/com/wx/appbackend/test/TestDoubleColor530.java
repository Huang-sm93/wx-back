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
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class TestDoubleColor530 {

    public static void main(String[] args) throws WriteException, IOException {
        int startTimes = 200;
        int endTimes = startTimes+50;
        int size = 300;
        List<List<Integer>> mostRedList = getMostRed(startTimes, endTimes, size);
        List<String[]> historyRed = new ArrayList<>();
        List<CellInfo> list = ReadExcelUtility.getArrFileNameNew("D:\\Work\\wx-app-backend-master\\最新历史记录.xls", 0, 20);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> mostList = mostRedList.get(i).subList(0, 8);
            List<Integer> lessList = mostRedList.get(i).subList(mostRedList.get(i).size()-6, mostRedList.get(i).size()-2);
            String[] red = new String[14];
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < 6; j++) {
                red[j] = Integer.toString(list.get(i).values[j]);
                count1 = count1 + (mostList.contains(list.get(i).values[j]) ? 1 : 0);
                count2 = count2 + (lessList.contains(list.get(i).values[j]) ? 1 : 0);
            }
            red[7] = Integer.toString(count1);
            red[8] = Integer.toString(count2);
            red[10] = Integer.toString(count1 + count2);
            red[11] = mostList.toString();
            red[13] = lessList.toString();
            historyRed.add(red);
        }
        WritableWorkbook book = null;
        if (historyRed.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("统计命中2.xls" ));
                ReadExcelUtility.writeFile3(historyRed, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
    }

    public static List<List<Integer>> getMostRed(int startTimes, int endTimes, int size) throws WriteException, IOException {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = startTimes; i < endTimes; i++) {
            List<CellInfo> list = ReadExcelUtility.getArrFileNameNew("D:\\Work\\wx-app-backend-master\\最新历史记录.xls", i, i+size);
            CellNumber[] allRed = new CellNumber[34];
            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int j = 0; j < list.size(); j++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int k = 0; k < 6; k++) {
                    int index = list.get(j).values[k];
                    if (allRed[index] == null){
                        allRed[index] = new CellNumber(index, 0);
                    }
                    allRed[index].count = allRed[index].count + 1;
                }
            }
            List<Integer> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).map(o->o.number).collect(Collectors.toList());
            result.add(redList);
        }
        return result;
    }
    public static String getCalculateResult() throws WriteException, IOException {
        List<Integer> redAll = ReadExcelUtility.getLastNumber();

        System.out.println("redAll:" + redAll);
        StringBuffer bf = new StringBuffer();
        bf.append("redAll:" + redAll + "\n");
        Workbook workbook = null;
        try {
            // 解析路径的file文件
            workbook = Workbook.getWorkbook(new File("D:\\Work\\wx-app-backend-master\\预测DC.xls"));

            // 获取第一张工作表
            Sheet sheet = workbook.getSheet(0);
            CellNumber[] allRed = new CellNumber[34];
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
            }
            List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());

            int sizeLeft = redList.size() > 8 ? 8 : redList.size();
            int sizeRight = 6;

            int countRed = 0;
            for (int i = 0; i <sizeLeft; i++) {
                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
                bf.append("\t"+redList.get(i).number);
            }
//            for (int i = redList.size()/2; i < redList.size()/2 + sizeRight; i++) {
//                countRed = redAll.contains(redList.get(i).number) ? countRed+1 : countRed;
//                bf.append("\t"+redList.get(i).number);
//            }
            bf.append("\n"+"red："+countRed + "\n");
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

