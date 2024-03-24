package com.wx.appbackend.ssq;

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
public class SSQ20240304BLIUE {

    public static void main(String[] args) throws WriteException, IOException {
        int countSize = 64;
        List<List<CellNumber>> redAll = new ArrayList<>();
        for (int k = 23; k < 28; k++) {
            String indexName = String.format("0%s",k);
            String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                    "/appbackend/ssq/ssq%s蓝.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getBFBLUE(countSize, name);
        CellNumber[] allRed = new CellNumber[17];
        for (int i = 1; i < 17; i++) {
            allRed[i] = new CellNumber(i, 0);
        }

            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < lastList.size(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int j = 0; j < 1; j++) {
                    int index = lastList.get(i).get(j);
                    allRed[index].count = allRed[index].count + 1;
                }

            }
            List<CellNumber> redList = Arrays.stream(allRed).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
            redAll.add(redList);
        }
        WritableWorkbook book = null;
        if (redAll.size() > 0){
            try {
                book = Workbook.createWorkbook(
                        new File(String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx/appbackend/" +
                                "ssq/0312蓝统计ssq%s.xls", countSize )));
                ReadExcelUtility.writeFileSSQBlue(redAll, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }

}

