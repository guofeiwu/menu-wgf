package com.menu.wgf.model;

import java.util.Date;

public class Material {
    private Integer tMaterialPkid;

    private String tMaterialName;

    private Integer tMaterialMenuPkid;

    private Date tMaterialCdt;

    private Date tMaterialUdt;

    private Integer tMaterialDelete;

    public Integer gettMaterialPkid() {
        return tMaterialPkid;
    }

    public void settMaterialPkid(Integer tMaterialPkid) {
        this.tMaterialPkid = tMaterialPkid;
    }

    public String gettMaterialName() {
        return tMaterialName;
    }

    public void settMaterialName(String tMaterialName) {
        this.tMaterialName = tMaterialName == null ? null : tMaterialName.trim();
    }

    public Integer gettMaterialMenuPkid() {
        return tMaterialMenuPkid;
    }

    public void settMaterialMenuPkid(Integer tMaterialMenuPkid) {
        this.tMaterialMenuPkid = tMaterialMenuPkid;
    }

    public Date gettMaterialCdt() {
        return tMaterialCdt;
    }

    public void settMaterialCdt(Date tMaterialCdt) {
        this.tMaterialCdt = tMaterialCdt;
    }

    public Date gettMaterialUdt() {
        return tMaterialUdt;
    }

    public void settMaterialUdt(Date tMaterialUdt) {
        this.tMaterialUdt = tMaterialUdt;
    }

    public Integer gettMaterialDelete() {
        return tMaterialDelete;
    }

    public void settMaterialDelete(Integer tMaterialDelete) {
        this.tMaterialDelete = tMaterialDelete;
    }
}