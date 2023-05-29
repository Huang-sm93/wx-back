package com.wx.appbackend.study.genericparadigm;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/3/23
 */
public class GenericParadigmTest {
    public static void main(String[] args) {

    }

    public static <T extends Number> double add(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }
}
