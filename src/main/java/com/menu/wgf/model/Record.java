package com.menu.wgf.model;

import java.util.Date;

public class Record {
    private Integer tRecordPkid;

    private Integer tRecordUserPkid;

    private Integer tRecordMenuPkid;

    private Date tRecordCdt;

    private Integer tRecordDelete;

    private Date tRecordUdt;

    public Integer gettRecordPkid() {
        return tRecordPkid;
    }

    public void settRecordPkid(Integer tRecordPkid) {
        this.tRecordPkid = tRecordPkid;
    }

    public Integer gettRecordUserPkid() {
        return tRecordUserPkid;
    }

    public void settRecordUserPkid(Integer tRecordUserPkid) {
        this.tRecordUserPkid = tRecordUserPkid;
    }

    public Integer gettRecordMenuPkid() {
        return tRecordMenuPkid;
    }

    public void settRecordMenuPkid(Integer tRecordMenuPkid) {
        this.tRecordMenuPkid = tRecordMenuPkid;
    }

    public Date gettRecordCdt() {
        return tRecordCdt;
    }

    public void settRecordCdt(Date tRecordCdt) {
        this.tRecordCdt = tRecordCdt;
    }

    public Integer gettRecordDelete() {
        return tRecordDelete;
    }

    public void settRecordDelete(Integer tRecordDelete) {
        this.tRecordDelete = tRecordDelete;
    }

    public Date gettRecordUdt() {
        return tRecordUdt;
    }

    public void settRecordUdt(Date tRecordUdt) {
        this.tRecordUdt = tRecordUdt;
    }
}