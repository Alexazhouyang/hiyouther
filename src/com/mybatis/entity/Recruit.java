package com.mybatis.entity;

import java.util.Date;

public class Recruit {
    private Integer rid;

    private Integer hid;

    private String rcompetence;

    private String rworktime;

    private Date rsctime;

    private Date rmonth;

    private String rnumbers;

    private Integer rcancel;

    private String rname;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getRcompetence() {
        return rcompetence;
    }

    public void setRcompetence(String rcompetence) {
        this.rcompetence = rcompetence == null ? null : rcompetence.trim();
    }

    public String getRworktime() {
        return rworktime;
    }

    public void setRworktime(String rworktime) {
        this.rworktime = rworktime == null ? null : rworktime.trim();
    }

    public Date getRsctime() {
        return rsctime;
    }

    public void setRsctime(Date rsctime) {
        this.rsctime = rsctime;
    }

    public Date getRmonth() {
        return rmonth;
    }

    public void setRmonth(Date rmonth) {
        this.rmonth = rmonth;
    }

    public String getRnumbers() {
        return rnumbers;
    }

    public void setRnumbers(String rnumbers) {
        this.rnumbers = rnumbers == null ? null : rnumbers.trim();
    }

    public Integer getRcancel() {
        return rcancel;
    }

    public void setRcancel(Integer rcancel) {
        this.rcancel = rcancel;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }
}