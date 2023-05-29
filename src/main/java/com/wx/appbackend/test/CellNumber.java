package com.wx.appbackend.test;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/26
 */
public class CellNumber implements Comparable {
    public int number;
    public int count;

    public CellNumber(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        CellNumber cellNumber = (CellNumber) o;
        return this.count - cellNumber.count;
    }
}
