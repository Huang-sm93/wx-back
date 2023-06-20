package com.wx.appbackend.doublecolor.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class BallNumbersReqDTO implements Serializable {
    public String ids;
    public List<int[]> history;

    public int numberIndex;

    public String date;

    public int number1;
    public int number2;
    public int number3;
    public int number4;
    public int number5;
    public int number6;
    public int number7;
    public int indexStart;
    public int indexEnd;
    public int indexSize;
    public int size;

    public int num6;
    public int num7;
    public int startSize;

    public String n1;
    public String n2;
}
