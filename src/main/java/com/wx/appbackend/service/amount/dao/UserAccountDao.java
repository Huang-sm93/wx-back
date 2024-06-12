package com.wx.appbackend.service.amount.dao;

import java.util.List;
import com.wx.appbackend.service.amount.entity.UserAccount;
import model.UserAccountExample;
import org.apache.ibatis.annotations.Param;

public interface UserAccountDao {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UserAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UserAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UserAccount row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UserAccount row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UserAccount> selectByExample(UserAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UserAccount selectByPrimaryKey(Long id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") UserAccount row, @Param("example") UserAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") UserAccount row, @Param("example") UserAccountExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UserAccount row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UserAccount row);
}