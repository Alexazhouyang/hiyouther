package com.mybatis.entity;

import java.util.Date;

public class Boss {
    private Integer bid;

    private String busername;

    private String btouxiang;

    private String btel;

    private String bphone;

    private String bqq;

    private String bemail;

    private String bweibo;

    private String bwechat;

    private String bpassword;

    private String brealname;

    private String bidcard;

    private String bcontact;

    private String bsex;

    private String baddress;

    private String bsign;

    private Integer bcancel;

    private String bcredit;

    private String breport;

    private Date binsettime;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBusername() {
        return busername;
    }

    public void setBusername(String busername) {
        this.busername = busername == null ? null : busername.trim();
    }

    public String getBtouxiang() {
        return btouxiang;
    }

    public void setBtouxiang(String btouxiang) {
        this.btouxiang = btouxiang == null ? null : btouxiang.trim();
    }

    public String getBtel() {
        return btel;
    }

    public void setBtel(String btel) {
        this.btel = btel == null ? null : btel.trim();
    }

    public String getBphone() {
        return bphone;
    }

    public void setBphone(String bphone) {
        this.bphone = bphone == null ? null : bphone.trim();
    }

    public String getBqq() {
        return bqq;
    }

    public void setBqq(String bqq) {
        this.bqq = bqq == null ? null : bqq.trim();
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail == null ? null : bemail.trim();
    }

    public String getBweibo() {
        return bweibo;
    }

    public void setBweibo(String bweibo) {
        this.bweibo = bweibo == null ? null : bweibo.trim();
    }

    public String getBwechat() {
        return bwechat;
    }

    public void setBwechat(String bwechat) {
        this.bwechat = bwechat == null ? null : bwechat.trim();
    }

    public String getBpassword() {
        return bpassword;
    }

    public void setBpassword(String bpassword) {
        this.bpassword = bpassword == null ? null : bpassword.trim();
    }

    public String getBrealname() {
        return brealname;
    }

    public void setBrealname(String brealname) {
        this.brealname = brealname == null ? null : brealname.trim();
    }

    public String getBidcard() {
        return bidcard;
    }

    public void setBidcard(String bidcard) {
        this.bidcard = bidcard == null ? null : bidcard.trim();
    }

    public String getBcontact() {
        return bcontact;
    }

    public void setBcontact(String bcontact) {
        this.bcontact = bcontact == null ? null : bcontact.trim();
    }

    public String getBsex() {
        return bsex;
    }

    public void setBsex(String bsex) {
        this.bsex = bsex == null ? null : bsex.trim();
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress == null ? null : baddress.trim();
    }

    public String getBsign() {
        return bsign;
    }

    public void setBsign(String bsign) {
        this.bsign = bsign == null ? null : bsign.trim();
    }

    public Integer getBcancel() {
        return bcancel;
    }

    public void setBcancel(Integer bcancel) {
        this.bcancel = bcancel;
    }

    public String getBcredit() {
        return bcredit;
    }

    public void setBcredit(String bcredit) {
        this.bcredit = bcredit == null ? null : bcredit.trim();
    }

    public String getBreport() {
        return breport;
    }

    public void setBreport(String breport) {
        this.breport = breport == null ? null : breport.trim();
    }

    public Date getBinsettime() {
        return binsettime;
    }

    public void setBinsettime(Date binsettime) {
        this.binsettime = binsettime;
    }
}