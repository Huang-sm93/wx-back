package com.wx.appbackend.service.user.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserReqDto implements Serializable {

    public Long id;

    public String account;

    public String userName;

    public String password;

    public Timestamp birthday;

    public String phoneNumber;
    /**
     * 性别 男M 女W 默认值M
     */
    public String sex;

    public int pageIndex;

    public int pageSize;

    private static final long serialVersionUID = 1L;

}
