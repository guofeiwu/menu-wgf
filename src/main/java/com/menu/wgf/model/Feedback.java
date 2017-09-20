package com.menu.wgf.model;

import java.util.Date;

public class Feedback {
    private Integer tFeedbackPkid;

    private Integer tFeedbackUserPkid;

    private String tFeedbackContent;

    private Date tFeedbackCdt;

    private Date tFeedbackUdt;

    private Integer tFeedbackDelete;

    public Integer gettFeedbackPkid() {
        return tFeedbackPkid;
    }

    public void settFeedbackPkid(Integer tFeedbackPkid) {
        this.tFeedbackPkid = tFeedbackPkid;
    }

    public Integer gettFeedbackUserPkid() {
        return tFeedbackUserPkid;
    }

    public void settFeedbackUserPkid(Integer tFeedbackUserPkid) {
        this.tFeedbackUserPkid = tFeedbackUserPkid;
    }

    public String gettFeedbackContent() {
        return tFeedbackContent;
    }

    public void settFeedbackContent(String tFeedbackContent) {
        this.tFeedbackContent = tFeedbackContent == null ? null : tFeedbackContent.trim();
    }

    public Date gettFeedbackCdt() {
        return tFeedbackCdt;
    }

    public void settFeedbackCdt(Date tFeedbackCdt) {
        this.tFeedbackCdt = tFeedbackCdt;
    }

    public Date gettFeedbackUdt() {
        return tFeedbackUdt;
    }

    public void settFeedbackUdt(Date tFeedbackUdt) {
        this.tFeedbackUdt = tFeedbackUdt;
    }

    public Integer gettFeedbackDelete() {
        return tFeedbackDelete;
    }

    public void settFeedbackDelete(Integer tFeedbackDelete) {
        this.tFeedbackDelete = tFeedbackDelete;
    }
}