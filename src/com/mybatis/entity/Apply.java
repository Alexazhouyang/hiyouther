package com.mybatis.entity;

import java.util.Date;

public class Apply {
    private Integer aid;

    private Integer mid;

    private Integer rid;

    private String aschedule;

    private Date atime;
    private String arefuse;

    private Date ainsertime;
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getAschedule() {
        return aschedule;
    }

    public void setAschedule(String aschedule) {
        this.aschedule = aschedule == null ? null : aschedule.trim();
    }

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public String getArefuse() {
        return arefuse;
    }

    public void setArefuse(String arefuse) {
        this.arefuse = arefuse == null ? null : arefuse.trim();
    }

    public Date getAinsertime() {
        return ainsertime;
    }

    public void setAinsertime(Date ainsertime) {
        this.ainsertime = ainsertime;
    }
}