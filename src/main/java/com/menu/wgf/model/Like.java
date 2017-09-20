package com.menu.wgf.model;

import java.util.Date;

public class Like {
    private Integer tLikePkid;

    private Integer tLikeUserPkid;

    private Integer tLikeMenuPkid;

    private Date tLikeCdt;

    private Date tLikeUdt;

    private Integer tLikeDelete;

    public Integer gettLikePkid() {
        return tLikePkid;
    }

    public void settLikePkid(Integer tLikePkid) {
        this.tLikePkid = tLikePkid;
    }

    public Integer gettLikeUserPkid() {
        return tLikeUserPkid;
    }

    public void settLikeUserPkid(Integer tLikeUserPkid) {
        this.tLikeUserPkid = tLikeUserPkid;
    }

    public Integer gettLikeMenuPkid() {
        return tLikeMenuPkid;
    }

    public void settLikeMenuPkid(Integer tLikeMenuPkid) {
        this.tLikeMenuPkid = tLikeMenuPkid;
    }

    public Date gettLikeCdt() {
        return tLikeCdt;
    }

    public void settLikeCdt(Date tLikeCdt) {
        this.tLikeCdt = tLikeCdt;
    }

    public Date gettLikeUdt() {
        return tLikeUdt;
    }

    public void settLikeUdt(Date tLikeUdt) {
        this.tLikeUdt = tLikeUdt;
    }

    public Integer gettLikeDelete() {
        return tLikeDelete;
    }

    public void settLikeDelete(Integer tLikeDelete) {
        this.tLikeDelete = tLikeDelete;
    }
}