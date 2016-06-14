package com.mybatis.entity;

import java.util.Date;

public class Member {
    private Integer mid;

    private String memname;

    private String mtouxiang;

    private String mtel;

    private String mphone;

    private String mqq;

    private String memail;

    private String mweibo;

    private String mwechat;

    private String mpassword;

    private String mrealname;

    private String midcard;

    private String mcontact;

    private String msex;

    private String maddress;

    private String msign;

    private String mcancel;

    private String mcredit;

    private String mreport;

    private String mresume;

    private Date minsettime;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMemname() {
        return memname;
    }

    public void setMemname(String memname) {
        this.memname = memname == null ? null : memname.trim();
    }

    public String getMtouxiang() {
        return mtouxiang;
    }

    public void setMtouxiang(String mtouxiang) {
        this.mtouxiang = mtouxiang == null ? null : mtouxiang.trim();
    }

    public String getMtel() {
        return mtel;
    }

    public void setMtel(String mtel) {
        this.mtel = mtel == null ? null : mtel.trim();
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone == null ? null : mphone.trim();
    }

    public String getMqq() {
        return mqq;
    }

    public void setMqq(String mqq) {
        this.mqq = mqq == null ? null : mqq.trim();
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail == null ? null : memail.trim();
    }

    public String getMweibo() {
        return mweibo;
    }

    public void setMweibo(String mweibo) {
        this.mweibo = mweibo == null ? null : mweibo.trim();
    }

    public String getMwechat() {
        return mwechat;
    }

    public void setMwechat(String mwechat) {
        this.mwechat = mwechat == null ? null : mwechat.trim();
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword == null ? null : mpassword.trim();
    }

    public String getMrealname() {
        return mrealname;
    }

    public void setMrealname(String mrealname) {
        this.mrealname = mrealname == null ? null : mrealname.trim();
    }

    public String getMidcard() {
        return midcard;
    }

    public void setMidcard(String midcard) {
        this.midcard = midcard == null ? null : midcard.trim();
    }

    public String getMcontact() {
        return mcontact;
    }

    public void setMcontact(String mcontact) {
        this.mcontact = mcontact == null ? null : mcontact.trim();
    }

    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex == null ? null : msex.trim();
    }

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress == null ? null : maddress.trim();
    }

    public String getMsign() {
        return msign;
    }

    public void setMsign(String msign) {
        this.msign = msign == null ? null : msign.trim();
    }

    public String getMcancel() {
        return mcancel;
    }

    public void setMcancel(String mcancel) {
        this.mcancel = mcancel == null ? null : mcancel.trim();
    }

    public String getMcredit() {
        return mcredit;
    }

    public void setMcredit(String mcredit) {
        this.mcredit = mcredit == null ? null : mcredit.trim();
    }

    public String getMreport() {
        return mreport;
    }

    public void setMreport(String mreport) {
        this.mreport = mreport == null ? null : mreport.trim();
    }

    public String getMresume() {
        return mresume;
    }

    public void setMresume(String mresume) {
        this.mresume = mresume == null ? null : mresume.trim();
    }

    public Date getMinsettime() {
        return minsettime;
    }

    public void setMinsettime(Date minsettime) {
        this.minsettime = minsettime;
    }
}