package com.menu.wgf.model;

import java.util.Date;

public class Share {
    private Integer tSharePkid;

    private Integer tShareUserPkid;

    private Integer tShareMenuPkid;

    private Date tShareCdt;

    private Date tShareUdt;

    public Integer gettSharePkid() {
        return tSharePkid;
    }

    public void settSharePkid(Integer tSharePkid) {
        this.tSharePkid = tSharePkid;
    }

    public Integer gettShareUserPkid() {
        return tShareUserPkid;
    }

    public void settShareUserPkid(Integer tShareUserPkid) {
        this.tShareUserPkid = tShareUserPkid;
    }

    public Integer gettShareMenuPkid() {
        return tShareMenuPkid;
    }

    public void settShareMenuPkid(Integer tShareMenuPkid) {
        this.tShareMenuPkid = tShareMenuPkid;
    }

    public Date gettShareCdt() {
        return tShareCdt;
    }

    public void settShareCdt(Date tShareCdt) {
        this.tShareCdt = tShareCdt;
    }

    public Date gettShareUdt() {
        return tShareUdt;
    }

    public void settShareUdt(Date tShareUdt) {
        this.tShareUdt = tShareUdt;
    }
}