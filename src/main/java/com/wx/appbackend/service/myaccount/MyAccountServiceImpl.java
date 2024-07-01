package com.wx.appbackend.service.myaccount;

import com.google.common.collect.Lists;
import com.wx.appbackend.service.ItemConvert;
import com.wx.appbackend.service.myaccount.dao.MyAccountDao;
import com.wx.appbackend.service.myaccount.entity.MyAccountDO;
import com.wx.appbackend.service.myaccount.entity.MyAccountEntity;
import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;
import com.wx.appbackend.service.util.BigDecimalUtility;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
        entity.createTime = new Timestamp(System.currentTimeMillis());
        entity.updateTime = entity.createTime;
        return myAccountDao.insert(entity);
    }

    @Override
    public MyAccountResDTO getByUserId(long userId) throws Exception {
        MyAccountResDTO resDTO = new MyAccountResDTO();
        List<MyAccountEntity> list = myAccountDao.getByUserId(userId);
        if (CollectionUtils.isEmpty(list)) {
            return resDTO;
        }
        List<MyAccountDO> resList = list.stream().map(p->ItemConvert.toMyAccountEntity(p)).collect(Collectors.toList());
        resDTO.total = list.size();
        resDTO.totalIncome = list.stream().filter(e -> BigDecimalUtility.isIncome(e.amount)).
                map(p->p.amount).reduce(BigDecimal.ZERO, BigDecimal::add);
        resDTO.totalExpense = list.stream().filter(e -> !BigDecimalUtility.isIncome(e.amount)).
                map(p->p.amount).reduce(BigDecimal.ZERO, BigDecimal::add);
        resDTO.totalAmount = resDTO.totalIncome.add(resDTO.totalExpense);
        resDTO.monthGroupInfo = resList.stream().collect(Collectors.groupingBy(e -> {
            return e.createTime.substring(0, 7);
        }));
        return resDTO;
    }

    @Override
    public void delete(long id) throws Exception {
        myAccountDao.delete(id);
    }
}
