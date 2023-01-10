package com.example.wx.appbackend.doublecolor.entity;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/1/9
 */
public class GenerateNumReqDTO {
    //红色和最大值
    public int maxRedSum;
    //红色和最小值
    public int minRedSum;
    //红色和奇数=1、 偶数=2、 未定义=0
    public int redSumOddOrEven;
    //蓝色最大值
    public int maxBlueSum;
    //蓝色最小值
    public int minBlueSum;
    //蓝色奇数=1、 偶数=2、 未定义=0
    public int blueOddOrEven;
    //需要排除的红色数字
    public List<Integer> disableRedNumbers;
    //需要排除的蓝色数字
    public List<Integer> disableBlueNumbers;
    //是否需要排除历史记录
    public boolean excludeHistory;
    //输出几组
    public int outListSize;
}
