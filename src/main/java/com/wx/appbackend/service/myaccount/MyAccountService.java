package com.wx.appbackend.service.myaccount;

import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;

import java.util.List;

public interface MyAccountService {
    long insert(MyAccountReqDTO reqDTO) throws Exception;
    MyAccountResDTO getByUserId(long userId) throws Exception;
    void delete(long id) throws Exception;
}
