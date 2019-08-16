package com.qfedu.entity;

import java.util.Date;

public class HouseInfo {

    private Integer id;
    private String projectName;
    private String owner;
    private Integer idCard;
    private String hoseType;
    private Integer area;
    private Date creatTIme;

    public HouseInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getHoseType() {
        return hoseType;
    }

    public void setHoseType(String hoseType) {
        this.hoseType = hoseType;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Date getCreatTIme() {
        return creatTIme;
    }

    public void setCreatTIme(Date creatTIme) {
        this.creatTIme = creatTIme;
    }
}
