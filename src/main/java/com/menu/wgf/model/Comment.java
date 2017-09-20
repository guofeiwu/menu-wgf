package com.menu.wgf.model;

import java.util.Date;

public class Comment {
    private Integer tCommentPkid;

    private Integer tCommentUserPkid;

    private Integer tCommentMenuPkid;

    private String tCommentContent;

    private Date tCommentCdt;

    private Date tCommentUdt;

    private Integer tCommentDelete;

    public Integer gettCommentPkid() {
        return tCommentPkid;
    }

    public void settCommentPkid(Integer tCommentPkid) {
        this.tCommentPkid = tCommentPkid;
    }

    public Integer gettCommentUserPkid() {
        return tCommentUserPkid;
    }

    public void settCommentUserPkid(Integer tCommentUserPkid) {
        this.tCommentUserPkid = tCommentUserPkid;
    }

    public Integer gettCommentMenuPkid() {
        return tCommentMenuPkid;
    }

    public void settCommentMenuPkid(Integer tCommentMenuPkid) {
        this.tCommentMenuPkid = tCommentMenuPkid;
    }

    public String gettCommentContent() {
        return tCommentContent;
    }

    public void settCommentContent(String tCommentContent) {
        this.tCommentContent = tCommentContent == null ? null : tCommentContent.trim();
    }

    public Date gettCommentCdt() {
        return tCommentCdt;
    }

    public void settCommentCdt(Date tCommentCdt) {
        this.tCommentCdt = tCommentCdt;
    }

    public Date gettCommentUdt() {
        return tCommentUdt;
    }

    public void settCommentUdt(Date tCommentUdt) {
        this.tCommentUdt = tCommentUdt;
    }

    public Integer gettCommentDelete() {
        return tCommentDelete;
    }

    public void settCommentDelete(Integer tCommentDelete) {
        this.tCommentDelete = tCommentDelete;
    }
}