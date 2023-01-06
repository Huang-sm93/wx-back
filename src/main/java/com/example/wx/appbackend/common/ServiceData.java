package com.example.wx.appbackend.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceData<T> implements Serializable {
    private String code;
    private T bo;
    public ServiceData(){
        code = RetCode.getSuccessValue();
    }
    private static final long serialVersionUID = 1L;
}
