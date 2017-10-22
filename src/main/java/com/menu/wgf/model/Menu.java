package com.menu.wgf.model;

import java.util.Date;

public class Menu {
    private Integer tMenuPkid;

    private String tMenuName;

    private String tMenuMainIcon;

    private String tMenuDescription;

    private Integer tMenuLookTimes;

    private Integer tMenuUserPkid;

    private Integer tMenuType;

    private Integer tMenuTypeSun;

    private Integer tMenuDelete;

    private Date tMenuCdt;

    private Date tMenuUdt;

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

    public String gettMenuMainIcon() {
        return tMenuMainIcon;
    }

    public void settMenuMainIcon(String tMenuMainIcon) {
        this.tMenuMainIcon = tMenuMainIcon == null ? null : tMenuMainIcon.trim();
    }

    public String gettMenuDescription() {
        return tMenuDescription;
    }

    public void settMenuDescription(String tMenuDescription) {
        this.tMenuDescription = tMenuDescription == null ? null : tMenuDescription.trim();
    }

    public Integer gettMenuLookTimes() {
        return tMenuLookTimes;
    }

    public void settMenuLookTimes(Integer tMenuLookTimes) {
        this.tMenuLookTimes = tMenuLookTimes;
    }

    public Integer gettMenuUserPkid() {
        return tMenuUserPkid;
    }

    public void settMenuUserPkid(Integer tMenuUserPkid) {
        this.tMenuUserPkid = tMenuUserPkid;
    }

    public Integer gettMenuType() {
        return tMenuType;
    }

    public void settMenuType(Integer tMenuType) {
        this.tMenuType = tMenuType;
    }

    public Integer gettMenuTypeSun() {
        return tMenuTypeSun;
    }

    public void settMenuTypeSun(Integer tMenuTypeSun) {
        this.tMenuTypeSun = tMenuTypeSun;
    }

    public Integer gettMenuDelete() {
        return tMenuDelete;
    }

    public void settMenuDelete(Integer tMenuDelete) {
        this.tMenuDelete = tMenuDelete;
    }

    public Date gettMenuCdt() {
        return tMenuCdt;
    }

    public void settMenuCdt(Date tMenuCdt) {
        this.tMenuCdt = tMenuCdt;
    }

    public Date gettMenuUdt() {
        return tMenuUdt;
    }

    public void settMenuUdt(Date tMenuUdt) {
        this.tMenuUdt = tMenuUdt;
    }
}