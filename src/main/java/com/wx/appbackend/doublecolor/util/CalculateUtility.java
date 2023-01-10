package com.wx.appbackend.doublecolor.util;

import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.test.ReadExcelUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/12/16
 */
public class CalculateUtility {
    public static List<int[]> getListByPara(GenerateNumReqDTO reqDTO){
        int outSize = reqDTO.outListSize;
        List<int[]> result = new ArrayList<>();
        Random random = new Random();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        List<Integer> disableRedNumbers = reqDTO.disableRedNumbers;
        List<Integer> disableBlueNumbers = reqDTO.disableBlueNumbers;
        for (int i = 1; i < 34; i++) {
            if (!needExcludeNum(disableRedNumbers, i)){
                allRed.add(i);
            }
            if (i<17 && !needExcludeNum(disableBlueNumbers, i)){
                allBlue.add(i);
            }
        }
        while (outSize>0) {
            List<Integer> redTemp = new ArrayList<>(allRed);
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            int temp[] = new int[7];
            temp[6] = 40;
            int redSum = 0;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
                redSum = redSum+temp[j];
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            if (excludePara(reqDTO, temp, redSum)){
                continue;
            }
            result.add(temp);
            outSize--;
        }


        return result;
    }

    private static boolean needExcludeNum(List<Integer> disableRedNumbers, int i) {
        if (disableRedNumbers == null || disableRedNumbers.size()<1){
            return false;
        }
        return disableRedNumbers.contains(i);
    }

    private static boolean excludePara(GenerateNumReqDTO reqDTO, int[] temp, int redSum) {
        //红色和大于最大值
        if (reqDTO.maxRedSum > 0 && redSum > reqDTO.maxRedSum){
            return true;
        }
        //红色和小于最小值
        if (reqDTO.minRedSum > 0 && redSum < reqDTO.minRedSum){
            return true;
        }
        //红色和奇偶不一致
        if (reqDTO.redSumOddOrEven > 0 && redSum%2 != reqDTO.redSumOddOrEven%2){
            return true;
        }
        //蓝色和大于最大值
        if (reqDTO.maxBlueSum > 0 && temp[6] > reqDTO.maxBlueSum){
            return true;
        }
        //蓝色和小于最小值
        if (reqDTO.minBlueSum > 0 && temp[6] < reqDTO.minBlueSum){
            return true;
        }
        //蓝色和奇偶不一致
        if (reqDTO.blueOddOrEven > 0 && temp[6]%2 != reqDTO.blueOddOrEven%2){
            return true;
        }
        if (reqDTO.excludeHistory && isSame(temp)){
            return true;
        }
        return false;
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

    public static boolean isSame(int[] cur){
        for (int i = 0; i < historyList.size(); i++) {
            int temp[] = historyList.get(i);
            if (temp[0] == cur[0] &&
                    temp[1] == cur[1] &&
                    temp[2] == cur[2] &&
                    temp[3] == cur[3] &&
                    temp[4] == cur[4] &&
                    temp[5] == cur[5] &&
                    temp[6] == cur[6]){
                return true;
            }
        }
        return false;
    }
    public static List<int[]> historyList;
    static {
        historyList = ReadExcelUtility.getAllList();
    }
}
