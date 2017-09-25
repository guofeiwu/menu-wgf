package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 */
public class CommentDataObject {
    @ApiModelProperty(value = "用户主键",position = 1,required = true)
    public int userPkId;
    @ApiModelProperty(value = "晒晒主键",position = 2,required = false)
    public int shaiPkId;
    @ApiModelProperty(value = "菜谱主键",position = 2,required = false)
    public int menuPkId;
    @ApiModelProperty(value = "评论内容",position = 2,required = true)
    public String content;
}
