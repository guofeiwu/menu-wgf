package com.menu.wgf.model;

import java.util.Date;

public class Shai {
    private Integer tShaiPkid;

    private Integer tShaiUserPkid;

    private String tShaiPictureAddress;

    private String tShaiDesc;

    private Date tShaiCdt;

    private Date tShaiUdt;

    private Integer tShaiDelete;

    public Integer gettShaiPkid() {
        return tShaiPkid;
    }

    public void settShaiPkid(Integer tShaiPkid) {
        this.tShaiPkid = tShaiPkid;
    }

    public Integer gettShaiUserPkid() {
        return tShaiUserPkid;
    }

    public void settShaiUserPkid(Integer tShaiUserPkid) {
        this.tShaiUserPkid = tShaiUserPkid;
    }

    public String gettShaiPictureAddress() {
        return tShaiPictureAddress;
    }

    public void settShaiPictureAddress(String tShaiPictureAddress) {
        this.tShaiPictureAddress = tShaiPictureAddress == null ? null : tShaiPictureAddress.trim();
    }

    public String gettShaiDesc() {
        return tShaiDesc;
    }

    public void settShaiDesc(String tShaiDesc) {
        this.tShaiDesc = tShaiDesc == null ? null : tShaiDesc.trim();
    }

    public Date gettShaiCdt() {
        return tShaiCdt;
    }

    public void settShaiCdt(Date tShaiCdt) {
        this.tShaiCdt = tShaiCdt;
    }

    public Date gettShaiUdt() {
        return tShaiUdt;
    }

    public void settShaiUdt(Date tShaiUdt) {
        this.tShaiUdt = tShaiUdt;
    }

    public Integer gettShaiDelete() {
        return tShaiDelete;
    }

    public void settShaiDelete(Integer tShaiDelete) {
        this.tShaiDelete = tShaiDelete;
    }
}