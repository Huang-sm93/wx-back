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
public class RandomForBigPrize1 {
    public static void main(String[] args) {
        List<Integer> cur = Arrays.asList(2,15,16,25,27);
        Random random = new Random();
        int winCount1 = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 34; i++) {
            list.add(i);
        }

        while (winCount1 < 1){
            List<Integer> list1 = new ArrayList<>(list);
            int countSame = 0;
            for (int j = 0; j < 12; j++) {
                int index = random.nextInt(33-j);
                int temp = list1.get(index);
                if (cur.contains(temp)) {
                    countSame++;
                }
                list1.remove(new Integer(temp));
            }
            if (countSame >= 6){
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
