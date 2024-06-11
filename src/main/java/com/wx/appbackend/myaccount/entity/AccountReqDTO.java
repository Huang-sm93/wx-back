package com.wx.appbackend.myaccount.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class AccountReqDTO implements Serializable {
    public long id;
    public String account;
    public String phoneNumber;
    public String userName;
    public String password;
    public String sex;
    public Date birthday;

}
