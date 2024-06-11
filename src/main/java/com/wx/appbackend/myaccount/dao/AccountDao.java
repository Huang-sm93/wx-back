package com.wx.appbackend.myaccount.dao;

import com.wx.appbackend.myaccount.entity.AccountReqDTO;
import com.wx.appbackend.myaccount.entity.AccountResDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/22
 */
@Mapper
public interface AccountDao {

    AccountResDTO selectById(long id) throws Exception;
    List<AccountResDTO> getPage() throws Exception;

    void update(AccountReqDTO accountReqDTO) throws Exception;
    int insert(AccountReqDTO accountReqDTO) throws Exception;
    void deleteByPrimaryKey(long id) throws Exception;
}
