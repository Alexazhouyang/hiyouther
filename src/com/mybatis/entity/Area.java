package com.mybatis.entity;

public class Area {
    private Integer arid;

    private String arname;

    private String arcountry;

    private String artype;

    private String artag;

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    public String getArname() {
        return arname;
    }

    public void setArname(String arname) {
        this.arname = arname == null ? null : arname.trim();
    }

    public String getArcountry() {
        return arcountry;
    }

    public void setArcountry(String arcountry) {
        this.arcountry = arcountry == null ? null : arcountry.trim();
    }

    public String getArtype() {
        return artype;
    }

    public void setArtype(String artype) {
        this.artype = artype == null ? null : artype.trim();
    }

    public String getArtag() {
        return artag;
    }

    public void setArtag(String artag) {
        this.artag = artag == null ? null : artag.trim();
    }
}