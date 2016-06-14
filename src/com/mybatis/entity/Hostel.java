package com.mybatis.entity;

public class Hostel {
    private Integer hid;

    private Integer bid;

    private Integer arid;

    private String hname;

    private String haddress;

    private String hphone;

    private String htel;

    private String htag;

    private String hscore;

    private String pauthentic;

    private String pbuscard;

    private String bcancel;

    private String breport;

    private String hsynopsis;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress == null ? null : haddress.trim();
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone == null ? null : hphone.trim();
    }

    public String getHtel() {
        return htel;
    }

    public void setHtel(String htel) {
        this.htel = htel == null ? null : htel.trim();
    }

    public String getHtag() {
        return htag;
    }

    public void setHtag(String htag) {
        this.htag = htag == null ? null : htag.trim();
    }

    public String getHscore() {
        return hscore;
    }

    public void setHscore(String hscore) {
        this.hscore = hscore == null ? null : hscore.trim();
    }

    public String getPauthentic() {
        return pauthentic;
    }

    public void setPauthentic(String pauthentic) {
        this.pauthentic = pauthentic == null ? null : pauthentic.trim();
    }

    public String getPbuscard() {
        return pbuscard;
    }

    public void setPbuscard(String pbuscard) {
        this.pbuscard = pbuscard == null ? null : pbuscard.trim();
    }

    public String getBcancel() {
        return bcancel;
    }

    public void setBcancel(String bcancel) {
        this.bcancel = bcancel == null ? null : bcancel.trim();
    }

    public String getBreport() {
        return breport;
    }

    public void setBreport(String breport) {
        this.breport = breport == null ? null : breport.trim();
    }

    public String getHsynopsis() {
        return hsynopsis;
    }

    public void setHsynopsis(String hsynopsis) {
        this.hsynopsis = hsynopsis == null ? null : hsynopsis.trim();
    }
}