package com.wx.appbackend.service.myaccount.service;

import com.wx.appbackend.service.myaccount.entity.AccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.AccountResDTO;

import java.util.List;

public interface AccountService {

    void update(AccountReqDTO reqDTO);
    int insert(AccountReqDTO reqDTO);
    AccountResDTO selectById(long id) throws Exception;
    void delete(long id) throws Exception;
    List<AccountResDTO> getPage() throws Exception;
}