package com.mybatis.entity;

import java.util.Date;

public class Picture  {
    private Integer picid;

    private Integer hid;

    private String pictitle;

    private Date pictime;

    private String pparent;

    private String picaddress;

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getPictitle() {
        return pictitle;
    }

    public void setPictitle(String pictitle) {
        this.pictitle = pictitle == null ? null : pictitle.trim();
    }

    public Date getPictime() {
        return pictime;
    }

    public void setPictime(Date pictime) {
        this.pictime = pictime;
    }

    public String getPparent() {
        return pparent;
    }

    public void setPparent(String pparent) {
        this.pparent = pparent == null ? null : pparent.trim();
    }

    public String getPicaddress() {
        return picaddress;
    }

    public void setPicaddress(String picaddress) {
        this.picaddress = picaddress == null ? null : picaddress.trim();
    }
}