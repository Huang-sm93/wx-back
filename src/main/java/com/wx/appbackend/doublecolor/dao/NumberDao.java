package com.wx.appbackend.doublecolor.dao;

import com.wx.appbackend.doublecolor.entity.BallNumbers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/22
 */
@Mapper
public interface NumberDao {

    int insertBatch(List<BallNumbers> list) throws Exception;

    BallNumbers getById(long l);

    BallNumbers getByKeys(BallNumbers ballNumbers);
    
    BallNumbers getByKeys1(BallNumbers ballNumbers);

    List<BallNumbers> getListByKeys(BallNumbers ballNumbers);

    void insertBatch1(List<BallNumbers> list);

    BallNumbers getById1(long l);

    BallNumbers getBFRById(int i);

    void insertBFRBatch(List<BallNumbers> list);

    BallNumbers getDCRById(long i);

    BallNumbers getDCByKeys(BallNumbers ballNumbers);

    BallNumbers getBFByKeys(BallNumbers ballNumbers);

    List<BallNumbers> getBFRByIdLimit(@Param("start") long start, @Param("limit") int limit);
    List<BallNumbers> getDCRByIdLimit(@Param("start") long start, @Param("limit") int limit);
}
