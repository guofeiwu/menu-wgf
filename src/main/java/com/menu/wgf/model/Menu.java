package com.menu.wgf.model;

import java.util.Date;

public class Menu {
    private Integer tMenuPkid;

    private String tMenuName;

    private Integer tMenuType;

    private Integer tMenuDelete;

    private Date tMenuUdt;

    private Date tMenuCdt;

    public Integer gettMenuPkid() {
        return tMenuPkid;
    }

    public void settMenuPkid(Integer tMenuPkid) {
        this.tMenuPkid = tMenuPkid;
    }

    public String gettMenuName() {
        return tMenuName;
    }

    public void settMenuName(String tMenuName) {
        this.tMenuName = tMenuName == null ? null : tMenuName.trim();
    }

    public Integer gettMenuType() {
        return tMenuType;
    }

    public void settMenuType(Integer tMenuType) {
        this.tMenuType = tMenuType;
    }

    public Integer gettMenuDelete() {
        return tMenuDelete;
    }

    public void settMenuDelete(Integer tMenuDelete) {
        this.tMenuDelete = tMenuDelete;
    }

    public Date gettMenuUdt() {
        return tMenuUdt;
    }

    public void settMenuUdt(Date tMenuUdt) {
        this.tMenuUdt = tMenuUdt;
    }

    public Date gettMenuCdt() {
        return tMenuCdt;
    }

    public void settMenuCdt(Date tMenuCdt) {
        this.tMenuCdt = tMenuCdt;
    }
}