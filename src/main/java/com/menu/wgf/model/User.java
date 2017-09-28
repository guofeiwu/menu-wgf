package com.menu.wgf.model;

import java.util.Date;

public class User {
    private Integer tUserPkid;

    private String tUserName;

    private String tUserPhone;

    private String tUserPassword;

    private Integer tUserSex;

    private Integer tUserPoint;

    private Integer tUserSign;

    private String tUserLevel;

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

    public String gettUserPhone() {
        return tUserPhone;
    }

    public void settUserPhone(String tUserPhone) {
        this.tUserPhone = tUserPhone == null ? null : tUserPhone.trim();
    }

    public String gettUserPassword() {
        return tUserPassword;
    }

    public void settUserPassword(String tUserPassword) {
        this.tUserPassword = tUserPassword == null ? null : tUserPassword.trim();
    }

    public Integer gettUserSex() {
        return tUserSex;
    }

    public void settUserSex(Integer tUserSex) {
        this.tUserSex = tUserSex;
    }

    public Integer gettUserPoint() {
        return tUserPoint;
    }

    public void settUserPoint(Integer tUserPoint) {
        this.tUserPoint = tUserPoint;
    }

    public Integer gettUserSign() {
        return tUserSign;
    }

    public void settUserSign(Integer tUserSign) {
        this.tUserSign = tUserSign;
    }

    public String gettUserLevel() {
        return tUserLevel;
    }

    public void settUserLevel(String tUserLevel) {
        this.tUserLevel = tUserLevel == null ? null : tUserLevel.trim();
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