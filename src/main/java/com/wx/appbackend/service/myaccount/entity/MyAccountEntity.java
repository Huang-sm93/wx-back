package com.wx.appbackend.service.myaccount.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class MyAccountEntity {
    public long id;
    public BigDecimal amount;
    public long userId;
    public Timestamp createTime;
    public Timestamp updateTime;
}
