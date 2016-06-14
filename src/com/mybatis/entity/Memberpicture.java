package com.mybatis.entity;

public class Memberpicture {
    private Integer mpid;

    private String mpaddress;

    private Integer mid;

    public Integer getMpid() {
        return mpid;
    }

    public void setMpid(Integer mpid) {
        this.mpid = mpid;
    }

    public String getMpaddress() {
        return mpaddress;
    }

    public void setMpaddress(String mpaddress) {
        this.mpaddress = mpaddress == null ? null : mpaddress.trim();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}