package com.example.wx.appbackend.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * UserPageDto
 * @author
 */
@Data
public class UserPageDto implements Serializable {

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