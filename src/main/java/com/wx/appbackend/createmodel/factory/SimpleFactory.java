package com.wx.appbackend.createmodel.factory;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class SimpleFactory {

    public static Phone createProduct(int type){
        switch (type){
            case 1 :
                return new PhoneA();
            case 2:
                return new PhoneB();
            default:
                return null;
        }
    }
}
