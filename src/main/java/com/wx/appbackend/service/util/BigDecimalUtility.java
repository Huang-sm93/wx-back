package com.wx.appbackend.service.util;

import java.math.BigDecimal;

/**
 * @Author: sm.huang
 * @Date: 2024/6/13  17:13
 **/
public class BigDecimalUtility {

    /**
     * 比较金额大小    BigDecimal的compareTo方法
     */
    public static int compareAmount(BigDecimal amount1, BigDecimal amount2) {
        if (amount1 == null) {
            return -1;
        }
        if (amount2 == null) {
            return 1;
        }
        return amount1.compareTo(amount2);
    }

    /**
     * 比较金额大小    BigDecimal的compareTo方法
     */
    public static boolean isIncome(BigDecimal amount) {
        if (amount == null) {
            return false;
        }
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
