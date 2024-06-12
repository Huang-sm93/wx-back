package com.wx.appbackend.service.myaccount.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class MyAccountReqDTO implements Serializable {
    public long id;
    public BigDecimal amount;
    public long userId;

}
