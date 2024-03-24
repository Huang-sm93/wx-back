package com.wx.appbackend.bfun;

import com.wx.appbackend.test.CellNumber;
import com.wx.appbackend.test.ReadExcelUtility;
import io.swagger.models.auth.In;
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
public class BigFun20240304 {

    public static void main(String[] args) throws WriteException, IOException {
        int countSize = 20;
        List<List<Integer>> curList = ReadExcelUtility.getLastNumbersAll("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx/appbackend/bfun/bf0315记录.xls");
        List<List<CellNumber>> redAll = new ArrayList<>();
        for (int k = 31; k >25; k--) {
            String indexName = String.format("0%s",k);
            String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                    "/appbackend/bfun/bf%s红1.xls", indexName);
            List<List<Integer>> lastList = ReadExcelUtility.getBF(countSize, name);
            CellNumber[] allRed = new CellNumber[36];
            for (int i = 1; i < 36; i++) {
                allRed[i] = new CellNumber(i, 0);
            }

            // 循环获取每一行数据 因为默认第一行为标题行，我们可以从 1 开始循环，如果需要读取标题行，从 0 开始
            for (int i = 0; i < lastList.size(); i++) {
                // 获取第一列的第 i 行信息 sheet.getCell(列，行)，下标从0开始
                for (int j = 0; j < 3; j++) {
                    int index = lastList.get(i).get(j);
                    allRed[index].count = allRed[index].count + 1;
                }

            }
            List<CellNumber> redList = Arrays.stream(allRed).filter(o -> o != null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
            redAll.add(redList);
        }
        List<List<Integer>> lastList = new ArrayList<>();
        lastList.add(Arrays.asList(0));
        for (int i = 0; i < 20; i++) {
            lastList.add(curList.get(i).subList(0, 5));
        }

        WritableWorkbook book = null;
        if (redAll.size() > 0){
            try {
                book = Workbook.createWorkbook(
                        new File(String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx/appbackend/" +
                                "bfun/不准0320统计%sbf红1.xls",countSize )));
                ReadExcelUtility.writeFileBFRed(redAll, book, 1, lastList);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }

}

