package com.wx.appbackend.service.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * wx_user
 * @author 
 */
@Data
public class User implements Serializable {

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

    private Date lastLogin;

    private Date createDate;

    private Date lastUpdateDate;

    private static final long serialVersionUID = 1L;
}