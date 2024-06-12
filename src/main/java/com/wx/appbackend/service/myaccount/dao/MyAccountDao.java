package com.wx.appbackend.service.myaccount.dao;

import com.wx.appbackend.service.myaccount.entity.MyAccountEntity;
import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/22
 */
@Mapper
public interface MyAccountDao {

    List<MyAccountEntity> getByUserId(long userId) throws Exception;
    int insert(MyAccountEntity entity) throws Exception;
    void delete(long id) throws Exception;
}
