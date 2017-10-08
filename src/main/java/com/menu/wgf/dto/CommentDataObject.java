package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 */
public class CommentDataObject {
    @ApiModelProperty(value = "晒晒主键",position = 2,required = false)
    public int shaiPkId;
    @ApiModelProperty(value = "菜谱主键",position = 2,required = false)
    public int menuPkId;
    @ApiModelProperty(value = "评论内容",position = 2,required = true)
    public String content;
    @ApiModelProperty(value = "评论时间",position = 2,required = false)
    public String commentTime;
    @ApiModelProperty(value = "用户头像地址",position = 2,required = false)
    public String userIconUrl;
    @ApiModelProperty(value = "用户名",position = 2,required = false)
    public String username;
    @ApiModelProperty(value = "是否是当前用户",position = 2,required = false,notes = "0表示是当前用户，-1表示不是当前用户")
    public int currentUser;

}
