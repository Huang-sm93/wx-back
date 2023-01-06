package com.example.wx.appbackend.common;

public enum RetCode {
    SUCCESS,
    ERROR,
    BUSINESS;
    public static String getSuccessValue(){
        return SUCCESS.toString();
    }

    public static String getErrorValue(){
        return ERROR.toString();
    }

    public static String getBusinessValue(){
        return BUSINESS.toString();
    }
}
