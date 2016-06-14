package com.mybatis.entity;

public class ProposedreportWithBLOBs extends Proposedreport {
    private String pcontent;

    private String pfankui;

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public String getPfankui() {
        return pfankui;
    }

    public void setPfankui(String pfankui) {
        this.pfankui = pfankui == null ? null : pfankui.trim();
    }
}