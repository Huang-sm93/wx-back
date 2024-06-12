package com.wx.appbackend.service.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * UserPageDto
 * @author
 */
public class UserResDto implements Serializable {

    /**
     * id
     */
    private Long id;

    private String userName;

    private String passwd;

    /**
     * 性别 男M 女W 默认值M
     */
    private String sex;

    /**
     * 有效标识
     */
    private String enabledFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLogin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    private static final long serialVersionUID = 1L;
}