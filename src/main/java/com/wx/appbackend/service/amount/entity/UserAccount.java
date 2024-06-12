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
    private Long id;

    /**
     * Column: user_id
     * Type: BIGINT
     * Remark: id
     */
    private Long userId;

    /**
     * Column: amount
     * Type: DECIMAL
     * Remark: 金额
     */
    private BigDecimal amount;

    /**
     * Column: update_time
     * Type: DATETIME
     */
    private Date updateTime;

    /**
     * Column: create_time
     * Type: DATETIME
     */
    private Date createTime;

    /**
     * Column: enabled_flag
     * Type: VARCHAR(1)
     * Default value: Y
     * Remark: 有效标识
     */
    private String enabledFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag == null ? null : enabledFlag.trim();
    }
}