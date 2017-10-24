package com.menu.wgf.model;

import java.util.Date;

public class UserSign {
    private Integer tSignPkid;

    private Integer tSignUserPkid;

    private Date tSignCdt;

    private Date tSignUdt;

    public Integer gettSignPkid() {
        return tSignPkid;
    }

    public void settSignPkid(Integer tSignPkid) {
        this.tSignPkid = tSignPkid;
    }

    public Integer gettSignUserPkid() {
        return tSignUserPkid;
    }

    public void settSignUserPkid(Integer tSignUserPkid) {
        this.tSignUserPkid = tSignUserPkid;
    }

    public Date gettSignCdt() {
        return tSignCdt;
    }

    public void settSignCdt(Date tSignCdt) {
        this.tSignCdt = tSignCdt;
    }

    public Date gettSignUdt() {
        return tSignUdt;
    }

    public void settSignUdt(Date tSignUdt) {
        this.tSignUdt = tSignUdt;
    }
}