package com.example.wx.appbackend.doublecolor.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/1/9
 */
@Data
public class GenerateNumReqDTO {
    //红色和最大值
    private int maxRedSum;
    //红色和最小值
    private int minRedSum;
    //红色和奇数=1、 偶数=2、 未定义=0
    private int redSumOddOrEven;
    //蓝色最大值
    private int maxBlueSum;
    //蓝色最小值
    private int minBlueSum;
    //蓝色奇数=1、 偶数=2、 未定义=0
    private int blueOddOrEven;
    //需要排除的红色数字
    private List<Integer> disableNumbers;
    //是否需要排除历史记录
    private boolean excludeHistory;
    //输出几组
    private int outListSize;
}
