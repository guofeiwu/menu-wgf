package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 菜单dto
 */
public class MenuDataObject {
    @ApiModelProperty(value = "菜单主键",position = 1,required = true)
    public int menuPkId;
    @ApiModelProperty(value = "菜单名字",position = 2,required = false)
    public String menuName;
    @ApiModelProperty(value = "菜谱主图",position =  2,required = true)
    public String mainIcon;
    @ApiModelProperty(value = "菜谱介绍",position =  2,required = true)
    public String introduce;
    @ApiModelProperty(value = "用户名",position =  2,required = true)
    public String userName;
    @ApiModelProperty(value = "用户头像",position =  2,required = true)
    public String userIconUrl;
    @ApiModelProperty(value = "是否是当前用户",position =  2,required = true)
    public int currentUser;
}
