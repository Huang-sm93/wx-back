package com.wx.appbackend.service.myaccount.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class MyAccountResDTO implements Serializable {
    public int total;
    public Map<String, List<MyAccountEntity>> monthGroupInfo;
    public BigDecimal totalIncome;
    public BigDecimal totalExpense;
    public BigDecimal totalAmount;
}
