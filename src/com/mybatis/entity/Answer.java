package com.mybatis.entity;

import java.util.Date;

public class Answer {
    private Integer anid;

    private Integer cid;

    private Date antime;

    private Integer listenerid;

    private Integer speakerid;

    private String type;

    private String listener;

    private String speaker;

    private String ccontent;

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getAntime() {
        return antime;
    }

    public void setAntime(Date antime) {
        this.antime = antime;
    }

    public Integer getListenerid() {
        return listenerid;
    }

    public void setListenerid(Integer listenerid) {
        this.listenerid = listenerid;
    }

    public Integer getSpeakerid() {
        return speakerid;
    }

    public void setSpeakerid(Integer speakerid) {
        this.speakerid = speakerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getListener() {
        return listener;
    }

    public void setListener(String listener) {
        this.listener = listener == null ? null : listener.trim();
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }
}