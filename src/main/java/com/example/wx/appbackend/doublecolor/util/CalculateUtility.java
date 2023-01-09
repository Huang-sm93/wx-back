package com.example.wx.appbackend.doublecolor.util;

import com.example.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.example.wx.appbackend.test.CellInfo;
import com.example.wx.appbackend.test.ReadExcelUtility;
import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/12/16
 */
public class CalculateUtility {
    public static void getListByPara(GenerateNumReqDTO reqDTO){
        int outSize = reqDTO.getOutListSize();
    }
    public static List<int[]> getResult(List<Integer> allBlue, List<Integer> allRed, Random random, int outListSize){
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(blueTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(redTemp, random);
            result.add(temp);
        }


        return result;
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

}
