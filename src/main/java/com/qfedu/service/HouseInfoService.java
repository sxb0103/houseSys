package com.qfedu.service;


import com.qfedu.entity.HouseInfo;


import java.util.List;

public interface HouseInfoService {

    public List<HouseInfo> findAllByIdCard(Integer idCard,Integer page, Integer limit);

    public List<HouseInfo> findAllByOwner(String owner,Integer page, Integer limit);

    public List<HouseInfo> findAll(Integer page, Integer limit);
}
