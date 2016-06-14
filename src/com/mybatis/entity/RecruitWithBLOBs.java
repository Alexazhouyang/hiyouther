package com.mybatis.entity;

public class RecruitWithBLOBs extends Recruit {
    private String rtask;

    private String rsynopsis;

    public String getRtask() {
        return rtask;
    }

    public void setRtask(String rtask) {
        this.rtask = rtask == null ? null : rtask.trim();
    }

    public String getRsynopsis() {
        return rsynopsis;
    }

    public void setRsynopsis(String rsynopsis) {
        this.rsynopsis = rsynopsis == null ? null : rsynopsis.trim();
    }
}