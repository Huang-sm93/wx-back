package com.example.wx.appbackend.user.entity;

import lombok.Data;

@Data
public class UserReqDto {

    private Long id;

    private String userName;

    private String passwd;

    /**
     * 性别 男M 女W 默认值M
     */
    private String sex;
}
