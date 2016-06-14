package com.mybatis.entity;

import java.util.Date;

public class Proposedreport {
    private Integer prid;

    private Integer mid;

    private Integer hid;

    private String ptype;

    private Date ptime;

    private String pchedule;

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype == null ? null : ptype.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPchedule() {
        return pchedule;
    }

    public void setPchedule(String pchedule) {
        this.pchedule = pchedule == null ? null : pchedule.trim();
    }
}