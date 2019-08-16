package com.qfedu.dao;

import com.qfedu.entity.HouseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseInfoDao {

    public List<HouseInfo> findAllByIdCard(@Param("idCard") Integer idCard);

    public List<HouseInfo> findAllByOwner(@Param("owner") String owner);

    public List<HouseInfo> findAll();
}
