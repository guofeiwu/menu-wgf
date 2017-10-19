package com.menu.wgf.model;

import java.util.Date;

public class AppInfo {
    private Integer tAppPkid;

    private Float tAppVer;

    private String tAppDownloadUrl;

    private String tAppVerDesc;

    private Date tAppCdt;

    private Date tAppUdt;

    private Integer tAppDelete;

    public Integer gettAppPkid() {
        return tAppPkid;
    }

    public void settAppPkid(Integer tAppPkid) {
        this.tAppPkid = tAppPkid;
    }

    public Float gettAppVer() {
        return tAppVer;
    }

    public void settAppVer(Float tAppVer) {
        this.tAppVer = tAppVer;
    }

    public String gettAppDownloadUrl() {
        return tAppDownloadUrl;
    }

    public void settAppDownloadUrl(String tAppDownloadUrl) {
        this.tAppDownloadUrl = tAppDownloadUrl == null ? null : tAppDownloadUrl.trim();
    }

    public String gettAppVerDesc() {
        return tAppVerDesc;
    }

    public void settAppVerDesc(String tAppVerDesc) {
        this.tAppVerDesc = tAppVerDesc == null ? null : tAppVerDesc.trim();
    }

    public Date gettAppCdt() {
        return tAppCdt;
    }

    public void settAppCdt(Date tAppCdt) {
        this.tAppCdt = tAppCdt;
    }

    public Date gettAppUdt() {
        return tAppUdt;
    }

    public void settAppUdt(Date tAppUdt) {
        this.tAppUdt = tAppUdt;
    }

    public Integer gettAppDelete() {
        return tAppDelete;
    }

    public void settAppDelete(Integer tAppDelete) {
        this.tAppDelete = tAppDelete;
    }
}