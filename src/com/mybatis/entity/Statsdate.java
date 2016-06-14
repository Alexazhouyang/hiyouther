package com.mybatis.entity;

import java.util.Date;

public class Statsdate {
    private Integer sdid;

    private Integer sdtotal;

    private Date sdsettime;

    public Integer getSdid() {
        return sdid;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public Integer getSdtotal() {
        return sdtotal;
    }

    public void setSdtotal(Integer sdtotal) {
        this.sdtotal = sdtotal;
    }

    public Date getSdsettime() {
        return sdsettime;
    }

    public void setSdsettime(Date sdsettime) {
        this.sdsettime = sdsettime;
    }
}