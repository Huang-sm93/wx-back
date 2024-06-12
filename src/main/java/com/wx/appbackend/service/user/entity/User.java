package com.wx.appbackend.service.user.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    /**
     * id
     */
    public Long id;

    public String userName;

    public String passwd;

    /**
     * 性别 男M 女W 默认值M
     */
    public String sex;

    /**
     * 有效标识
     */
    public String enabledFlag;

    public Date lastLogin;

    public Date createDate;

    public Date lastUpdateDate;

    public static final long serialVersionUID = 1L;
}