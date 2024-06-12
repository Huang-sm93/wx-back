package com.wx.appbackend.service.amount.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Table: user_account
 */
public class UserAccount {
    /**
     * Column: id
     * Type: BIGINT
     * Remark: id
     */
    public Long id;

    /**
     * Column: user_id
     * Type: BIGINT
     * Remark: id
     */
    public Long userId;

    /**
     * Column: amount
     * Type: DECIMAL
     * Remark: 金额
     */
    public BigDecimal amount;

    /**
     * Column: update_time
     * Type: DATETIME
     */
    public Date updateTime;

    /**
     * Column: create_time
     * Type: DATETIME
     */
    public Date createTime;

    /**
     * Column: enabled_flag
     * Type: VARCHAR(1)
     * Default value: Y
     * Remark: 有效标识
     */
    public String enabledFlag;
    
}