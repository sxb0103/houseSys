package com.qfedu.controller;


import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.HouseInfo;
import com.qfedu.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HouseInfoController {

    @Autowired
    HouseInfoService houseInfoService;

    @RequestMapping("/findAll.do")
    @ResponseBody
    public JsonResult findAll(String textId, String text, Integer page, Integer limit) {

        List<HouseInfo> houseInfoList = null;

        if(textId==null){

            houseInfoList = houseInfoService.findAll(page,limit);

            System.out.println(houseInfoList);
        }else{
            if (textId.equals("2")) {

                Integer idCard = Integer.valueOf(text);
                houseInfoList = houseInfoService.findAllByIdCard(idCard, page, limit);
            } else if(textId.equals("1")) {

                houseInfoList = houseInfoService.findAllByOwner(text, page, limit);

            }
        }
        long total = ((Page) houseInfoList).getTotal();

        JsonResult jsonResult = new JsonResult(0, "", total, houseInfoList);

        return jsonResult;
    }
}
