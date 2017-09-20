package com.menu.wgf.model;

import java.util.Date;

public class User {
    private Integer tUserPkid;

    private String tUserName;

    private Integer tUserSex;

    private String tUserBirthday;

    private String tUserIcon;

    private Date tUserUdt;

    private Date tUserCdt;

    public Integer gettUserPkid() {
        return tUserPkid;
    }

    public void settUserPkid(Integer tUserPkid) {
        this.tUserPkid = tUserPkid;
    }

    public String gettUserName() {
        return tUserName;
    }

    public void settUserName(String tUserName) {
        this.tUserName = tUserName == null ? null : tUserName.trim();
    }

    public Integer gettUserSex() {
        return tUserSex;
    }

    public void settUserSex(Integer tUserSex) {
        this.tUserSex = tUserSex;
    }

    public String gettUserBirthday() {
        return tUserBirthday;
    }

    public void settUserBirthday(String tUserBirthday) {
        this.tUserBirthday = tUserBirthday == null ? null : tUserBirthday.trim();
    }

    public String gettUserIcon() {
        return tUserIcon;
    }

    public void settUserIcon(String tUserIcon) {
        this.tUserIcon = tUserIcon == null ? null : tUserIcon.trim();
    }

    public Date gettUserUdt() {
        return tUserUdt;
    }

    public void settUserUdt(Date tUserUdt) {
        this.tUserUdt = tUserUdt;
    }

    public Date gettUserCdt() {
        return tUserCdt;
    }

    public void settUserCdt(Date tUserCdt) {
        this.tUserCdt = tUserCdt;
    }
}