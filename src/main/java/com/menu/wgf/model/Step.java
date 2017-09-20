package com.menu.wgf.model;

import java.util.Date;

public class Step {
    private Integer tStepPkid;

    private Integer tStepMenuPkid;

    private String tStepPicAddress;

    private String tStepDescription;

    private Date tStepUdt;

    private Date tStepCdt;

    private Integer tStepDelete;

    public Integer gettStepPkid() {
        return tStepPkid;
    }

    public void settStepPkid(Integer tStepPkid) {
        this.tStepPkid = tStepPkid;
    }

    public Integer gettStepMenuPkid() {
        return tStepMenuPkid;
    }

    public void settStepMenuPkid(Integer tStepMenuPkid) {
        this.tStepMenuPkid = tStepMenuPkid;
    }

    public String gettStepPicAddress() {
        return tStepPicAddress;
    }

    public void settStepPicAddress(String tStepPicAddress) {
        this.tStepPicAddress = tStepPicAddress == null ? null : tStepPicAddress.trim();
    }

    public String gettStepDescription() {
        return tStepDescription;
    }

    public void settStepDescription(String tStepDescription) {
        this.tStepDescription = tStepDescription == null ? null : tStepDescription.trim();
    }

    public Date gettStepUdt() {
        return tStepUdt;
    }

    public void settStepUdt(Date tStepUdt) {
        this.tStepUdt = tStepUdt;
    }

    public Date gettStepCdt() {
        return tStepCdt;
    }

    public void settStepCdt(Date tStepCdt) {
        this.tStepCdt = tStepCdt;
    }

    public Integer gettStepDelete() {
        return tStepDelete;
    }

    public void settStepDelete(Integer tStepDelete) {
        this.tStepDelete = tStepDelete;
    }
}