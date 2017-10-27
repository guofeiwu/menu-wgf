package com.menu.wgf.model;

import java.util.Date;

public class Thematic {
    private Integer tThematicPkid;

    private String tThematicPictureUrl;

    private String tThematicName;

    private Integer tThematicDelete;

    private Date tThematicCdt;

    private Date tThematicUdt;

    public Integer gettThematicPkid() {
        return tThematicPkid;
    }

    public void settThematicPkid(Integer tThematicPkid) {
        this.tThematicPkid = tThematicPkid;
    }

    public String gettThematicPictureUrl() {
        return tThematicPictureUrl;
    }

    public void settThematicPictureUrl(String tThematicPictureUrl) {
        this.tThematicPictureUrl = tThematicPictureUrl == null ? null : tThematicPictureUrl.trim();
    }

    public String gettThematicName() {
        return tThematicName;
    }

    public void settThematicName(String tThematicName) {
        this.tThematicName = tThematicName == null ? null : tThematicName.trim();
    }

    public Integer gettThematicDelete() {
        return tThematicDelete;
    }

    public void settThematicDelete(Integer tThematicDelete) {
        this.tThematicDelete = tThematicDelete;
    }

    public Date gettThematicCdt() {
        return tThematicCdt;
    }

    public void settThematicCdt(Date tThematicCdt) {
        this.tThematicCdt = tThematicCdt;
    }

    public Date gettThematicUdt() {
        return tThematicUdt;
    }

    public void settThematicUdt(Date tThematicUdt) {
        this.tThematicUdt = tThematicUdt;
    }
}