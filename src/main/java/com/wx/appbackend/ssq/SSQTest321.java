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
public class SSQTest321 {

    public static void main(String[] args) throws WriteException, IOException {
        String indexName = "0321";
        String name = String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx" +
                "/appbackend/ssq/ssq%s记录.xls", indexName);
        List<List<Integer>> lastList = ReadExcelUtility.getLastNumbersAll(name);
        int startIndex = 2;
        int step = 3;
        List<List<CellNumber>> redAll = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            CellNumber[] redList = new CellNumber[34];
            for (int j = 0; j < 34; j++) {
                redList[j] = new CellNumber(j, 0);
            }
            for (int j = i+startIndex; j < i+startIndex+step; j++) {
                List<Integer> integers = lastList.get(j);
                for (int k = 0; k < 6; k++) {
                    int index1 = integers.get(k);
                    redList[index1].count = redList[index1].count + 1;
                }
            }
            List<CellNumber> redList1 = Arrays.stream(redList).filter(o-> o!=null).sorted((o1, o2) -> o2.count - o1.count).collect(Collectors.toList());
            redAll.add(redList1);
        }

        if (redAll.size() > 0){
            WritableWorkbook book = null;
            try {
                book = Workbook.createWorkbook(
                        new File(String.format("/Users/sm.haung/Desktop/wx-back-master/src/main/java/com/wx/appbackend/" +
                                "ssq/0321统计ssq红%s.xls", indexName )));
                ReadExcelUtility.writeFileSSQRed(redAll, book, 1,lastList);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
    }

    private static final List<List<Integer>> myList = new ArrayList<>();

    static {
        myList.add(Arrays.asList(2,13,19,24,21,22, 3));
        myList.add(Arrays.asList(5,9,18,26,27,29, 3));
        myList.add(Arrays.asList(4,9,13,14,25,32, 3));
        myList.add(Arrays.asList(3,9,12,22,23,31, 3));
        myList.add(Arrays.asList(3,8,13,19,24,28, 3));
    }
}



