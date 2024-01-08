package com.wx.appbackend.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2024/1/2
 */
public class RandomForBigPrize2 {
    public static void main(String[] args) {
        long cur = 2*15*16*25*27*29;
        Random random = new Random();
        int winCount1 = 0;
        long count = 0;
        long maxVal = 33*32*31*30*29*28;
        while (winCount1 < 1){
            if (random.nextLong()%maxVal==cur){
                winCount1++;
            }
            count++;
            if (count % 1000000 == 0){
                System.out.println("has calculate times:" + count);
            }

        }
        System.out.println("一等：" + winCount1 + "\t 次数：" + count);

    }
}
