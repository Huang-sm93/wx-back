package com.wx.appbackend.service.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserEntity implements Serializable {

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

    /**
     * 有效标识
     */
    public String enabledFlag;

    public Timestamp lastLogin;

    public Timestamp createTime;

    public Timestamp updateTime;

    public static final long serialVersionUID = 1L;
}