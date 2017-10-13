package com.menu.wgf.model;

import java.util.Date;

public class Banners {
    private Integer tBannerPkid;

    private Integer tBannerMenuPkid;

    private String tBannerMenuDesc;

    private Date tBannerCdt;

    private Date tBannerUdt;

    private Integer tBannerDelete;

    public Integer gettBannerPkid() {
        return tBannerPkid;
    }

    public void settBannerPkid(Integer tBannerPkid) {
        this.tBannerPkid = tBannerPkid;
    }

    public Integer gettBannerMenuPkid() {
        return tBannerMenuPkid;
    }

    public void settBannerMenuPkid(Integer tBannerMenuPkid) {
        this.tBannerMenuPkid = tBannerMenuPkid;
    }

    public String gettBannerMenuDesc() {
        return tBannerMenuDesc;
    }

    public void settBannerMenuDesc(String tBannerMenuDesc) {
        this.tBannerMenuDesc = tBannerMenuDesc == null ? null : tBannerMenuDesc.trim();
    }

    public Date gettBannerCdt() {
        return tBannerCdt;
    }

    public void settBannerCdt(Date tBannerCdt) {
        this.tBannerCdt = tBannerCdt;
    }

    public Date gettBannerUdt() {
        return tBannerUdt;
    }

    public void settBannerUdt(Date tBannerUdt) {
        this.tBannerUdt = tBannerUdt;
    }

    public Integer gettBannerDelete() {
        return tBannerDelete;
    }

    public void settBannerDelete(Integer tBannerDelete) {
        this.tBannerDelete = tBannerDelete;
    }
}