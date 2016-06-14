package com.mybatis.entity;

import java.util.Date;

public class Statstype {
    private Integer stid;

    private String stname;

    private Date stsettime;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname == null ? null : stname.trim();
    }

    public Date getStsettime() {
        return stsettime;
    }

    public void setStsettime(Date stsettime) {
        this.stsettime = stsettime;
    }
}