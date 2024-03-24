package com.wx.appbackend.bfun;

import com.wx.appbackend.test.CellNumber;
import com.wx.appbackend.test.ReadExcelUtility;
import jxl.Workbook;
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
public class BigFunLastTime0316blue {

    public static void main(String[] args) throws WriteException, IOException {
        int countSize = 6*12;
        List<List<CellNumber>> redAll = new ArrayList<>();
        String indexName = "0315";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/bfun/bf%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        for (int k = 0; k < 11; k++) {
            CellNumber[] allRed = new CellNumber[13];
            for (int i = 1; i < 13; i++) {
                allRed[i] = new CellNumber(i, 0);
            }

            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = k; i < countSize+k; i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int j = 5; j < 7; j++) {
                    int index = lastList.get(i).get(j);
                    allRed[index].count = allRed[index].count + 1;
                }

            }
            List<CellNumber> redList = Arrays.stream(allRed).filter(o -> o != null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
            redAll.add(redList);
        }
        WritableWorkbook book = null;
        if (redAll.size() > 0){
            try {
                book = Workbook.createWorkbook(
                        new File(String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx/appbackend/" +
                                "bfun/最近%s次出现次数0318统计bf蓝.xls",countSize )));
                ReadExcelUtility.writeFileBFBlue1(redAll, book, 1, lastList);
                book.write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }

}

