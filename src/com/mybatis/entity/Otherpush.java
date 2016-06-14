package com.mybatis.entity;

import java.util.Date;

public class Otherpush {
    private Integer oid;

    private Integer userid;

    private String pushtime;

    private String pushcountcycle;

    private Integer pushcount;

    private Integer pushcountnum;

    private String pushobject;

    private String pushstatus;

    private Date executetime;

    private Integer executecount;

    private Date inserttime;

    private String usertype;

    private String pushtype;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPushtime() {
        return pushtime;
    }

    public void setPushtime(String pushtime) {
        this.pushtime = pushtime == null ? null : pushtime.trim();
    }

    public String getPushcountcycle() {
        return pushcountcycle;
    }

    public void setPushcountcycle(String pushcountcycle) {
        this.pushcountcycle = pushcountcycle == null ? null : pushcountcycle.trim();
    }

    public Integer getPushcount() {
        return pushcount;
    }

    public void setPushcount(Integer pushcount) {
        this.pushcount = pushcount;
    }

    public Integer getPushcountnum() {
        return pushcountnum;
    }

    public void setPushcountnum(Integer pushcountnum) {
        this.pushcountnum = pushcountnum;
    }

    public String getPushobject() {
        return pushobject;
    }

    public void setPushobject(String pushobject) {
        this.pushobject = pushobject == null ? null : pushobject.trim();
    }

    public String getPushstatus() {
        return pushstatus;
    }

    public void setPushstatus(String pushstatus) {
        this.pushstatus = pushstatus == null ? null : pushstatus.trim();
    }

    public Date getExecutetime() {
        return executetime;
    }

    public void setExecutetime(Date executetime) {
        this.executetime = executetime;
    }

    public Integer getExecutecount() {
        return executecount;
    }

    public void setExecutecount(Integer executecount) {
        this.executecount = executecount;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getPushtype() {
        return pushtype;
    }

    public void setPushtype(String pushtype) {
        this.pushtype = pushtype == null ? null : pushtype.trim();
    }
}