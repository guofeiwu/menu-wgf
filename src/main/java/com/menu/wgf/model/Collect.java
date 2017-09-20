package com.menu.wgf.model;

import java.util.Date;

public class Collect {
    private Integer tCollectPkid;

    private Integer tCollectUserPkid;

    private Integer tCollectMenuPkid;

    private Date tCollectCdt;

    private Date tCollectUdt;

    private Integer tCollectCancel;

    public Integer gettCollectPkid() {
        return tCollectPkid;
    }

    public void settCollectPkid(Integer tCollectPkid) {
        this.tCollectPkid = tCollectPkid;
    }

    public Integer gettCollectUserPkid() {
        return tCollectUserPkid;
    }

    public void settCollectUserPkid(Integer tCollectUserPkid) {
        this.tCollectUserPkid = tCollectUserPkid;
    }

    public Integer gettCollectMenuPkid() {
        return tCollectMenuPkid;
    }

    public void settCollectMenuPkid(Integer tCollectMenuPkid) {
        this.tCollectMenuPkid = tCollectMenuPkid;
    }

    public Date gettCollectCdt() {
        return tCollectCdt;
    }

    public void settCollectCdt(Date tCollectCdt) {
        this.tCollectCdt = tCollectCdt;
    }

    public Date gettCollectUdt() {
        return tCollectUdt;
    }

    public void settCollectUdt(Date tCollectUdt) {
        this.tCollectUdt = tCollectUdt;
    }

    public Integer gettCollectCancel() {
        return tCollectCancel;
    }

    public void settCollectCancel(Integer tCollectCancel) {
        this.tCollectCancel = tCollectCancel;
    }
}