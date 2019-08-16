package com.qfedu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.HouseInfoDao;
import com.qfedu.entity.HouseInfo;
import com.qfedu.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    @Autowired
    HouseInfoDao houseInfoDao;

    @Override
    public List<HouseInfo> findAllByIdCard(Integer idCard, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<HouseInfo> idCardList = houseInfoDao.findAllByIdCard(idCard);
        return idCardList;
    }

    @Override
    public List<HouseInfo> findAllByOwner(String owner, Integer page, Integer limit) {

        PageHelper.startPage(page,limit);
        List<HouseInfo> ownerList = houseInfoDao.findAllByOwner(owner);
        return ownerList;
    }

    @Override
    public List<HouseInfo> findAll(Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<HouseInfo> houseInfoList = houseInfoDao.findAll();

        return houseInfoList;
    }
}
