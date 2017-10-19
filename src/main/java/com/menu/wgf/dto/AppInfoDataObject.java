package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
public class AppInfoDataObject {
    @ApiModelProperty(value = "菜谱主键",position = 1,required = true)
    public double versionCode;
    @ApiModelProperty(value = "菜谱主键",position = 1,required = true)
    public String downloadUrl;
    @ApiModelProperty(value = "菜谱主键",position = 1,required = true)
    public String verDesc;

}
