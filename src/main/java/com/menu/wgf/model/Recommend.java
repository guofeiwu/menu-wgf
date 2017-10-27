package com.menu.wgf.model;

import java.util.Date;

public class Recommend {
    private Integer tRecommendPkid;

    private String tRecommendName;

    private Integer tRecommendType;

    private Date tRecommendCdt;

    private Date tRecommendUdt;

    private Integer tRecommendDelete;

    public Integer gettRecommendPkid() {
        return tRecommendPkid;
    }

    public void settRecommendPkid(Integer tRecommendPkid) {
        this.tRecommendPkid = tRecommendPkid;
    }

    public String gettRecommendName() {
        return tRecommendName;
    }

    public void settRecommendName(String tRecommendName) {
        this.tRecommendName = tRecommendName == null ? null : tRecommendName.trim();
    }

    public Integer gettRecommendType() {
        return tRecommendType;
    }

    public void settRecommendType(Integer tRecommendType) {
        this.tRecommendType = tRecommendType;
    }

    public Date gettRecommendCdt() {
        return tRecommendCdt;
    }

    public void settRecommendCdt(Date tRecommendCdt) {
        this.tRecommendCdt = tRecommendCdt;
    }

    public Date gettRecommendUdt() {
        return tRecommendUdt;
    }

    public void settRecommendUdt(Date tRecommendUdt) {
        this.tRecommendUdt = tRecommendUdt;
    }

    public Integer gettRecommendDelete() {
        return tRecommendDelete;
    }

    public void settRecommendDelete(Integer tRecommendDelete) {
        this.tRecommendDelete = tRecommendDelete;
    }
}