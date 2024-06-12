package com.wx.appbackend.service.user.entity;

import java.io.Serializable;

public class UserReqDto implements Serializable {

    public Long id;

    public String userName;

    public String passwd;

    /**
     * 性别 男M 女W 默认值M
     */
    public String sex;
}
