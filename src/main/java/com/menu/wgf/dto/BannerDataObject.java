package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
public class BannerDataObject {
    @ApiModelProperty(value = "菜谱主键",position = 1,required = true)
    public int menuPkId;
    @ApiModelProperty(value = "菜谱banner描述",position = 2,required = true)
    public String menuDesc;
    @ApiModelProperty(value = "菜谱主图",position = 2,required = true)
    public String mainIcon;
}
