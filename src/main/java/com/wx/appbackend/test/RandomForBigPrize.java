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
public class RandomForBigPrize {
    public static void main(String[] args) {
        List<Integer> cur = Arrays.asList(1,15,16,25,27);
        Random random = new Random();

                List<Integer> list = new ArrayList<>();
                for (int i = 1; i < 34; i++) {
                    list.add(i);
                }
                for (int i = 0; i < 1000; i++) {
                    List<Integer> list1 = new ArrayList<>(list);
                    List<Integer> list2 = new ArrayList<>();
                    int countSame = 0;
                    for (int j = 0; j < 12; j++) {
                        int index = random.nextInt(33-j);
                        int temp = list1.get(index);
                        list2.add(temp);
                        if (cur.contains(temp)) {
                            countSame++;
                        }
                        list1.remove(new Integer(temp));
                    }
                    list2.sort((o1, o2) -> o1 - o2);
                    System.out.println("list2:" + list2);
                    if (countSame >= 6){
                        System.out.println("一等：" + list2);
                    }

                }



    }
}
