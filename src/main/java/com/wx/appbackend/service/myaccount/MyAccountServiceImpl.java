package com.wx.appbackend.service.myaccount;

import com.google.common.collect.Lists;
import com.wx.appbackend.service.ItemConvert;
import com.wx.appbackend.service.myaccount.dao.MyAccountDao;
import com.wx.appbackend.service.myaccount.entity.MyAccountEntity;
import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyAccountServiceImpl implements MyAccountService {

    @Resource
    private MyAccountDao myAccountDao;

    @Override
    public long insert(MyAccountReqDTO reqDTO) throws Exception {
        MyAccountEntity entity = ItemConvert.toMyAccountEntity(reqDTO);
        return myAccountDao.insert(entity);
    }

    @Override
    public List<MyAccountResDTO> getByUserId(long userId) throws Exception {
        List<MyAccountEntity> list = myAccountDao.getByUserId(userId);
        if (CollectionUtils.isEmpty(list)){
            return Lists.newArrayList();
        }
        return list.stream().map(p->{return ItemConvert.toMyAccountResDTO(p);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(long id) throws Exception {
        myAccountDao.delete(id);
    }
}
