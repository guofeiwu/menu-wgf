package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author guofei_wu
 * email guofei_wu@163.com
 */
public class ShaiDataObject {
    //s.t_shai_picture_address address ,s.t_shai_cdt cTime, u.t_user_icon icon,u.t_user_name userName,s.t_shai_desc descr
    @ApiModelProperty(value = "晒晒主键",position = 1,required = true)
    public int pkid;
    @ApiModelProperty(value = "晒晒图片地址",position = 2,required = true)
    public String address;
    @ApiModelProperty(value = "晒晒创建时间",position = 2,required = true)
    public String cTime;
    @ApiModelProperty(value = "用户头像地址",position = 2,required = true)
    public String icon;
    @ApiModelProperty(value = "用户名",position = 2,required = true)
    public String userName;
    @ApiModelProperty(value = "晒晒描述",position = 2,required = true)
    public String descr;
    @ApiModelProperty(value = "晒晒被点赞次数",position = 2,required = false)
    public int shaiLike;
    @ApiModelProperty(value = "评论总数",position = 2,required = false)
    public int commentTotal;
    @ApiModelProperty(value = "浏览总数",position = 2,required = false)
    public int lookTotal;
    @ApiModelProperty(value = "是否是当前用户发布的",position = 2,required = false,notes = "0表示是，-1表示不是")
    public int currentUser;

}
