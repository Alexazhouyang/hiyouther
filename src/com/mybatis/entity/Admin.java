package com.mybatis.entity;

public class Admin {
    private Integer adid;

    private String adpassword;

    private String adaccount;

    private String adquanx;

    private String adname;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword == null ? null : adpassword.trim();
    }

    public String getAdaccount() {
        return adaccount;
    }

    public void setAdaccount(String adaccount) {
        this.adaccount = adaccount == null ? null : adaccount.trim();
    }

    public String getAdquanx() {
        return adquanx;
    }

    public void setAdquanx(String adquanx) {
        this.adquanx = adquanx == null ? null : adquanx.trim();
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }
}