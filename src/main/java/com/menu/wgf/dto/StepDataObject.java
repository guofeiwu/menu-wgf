package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 菜谱步骤 dto
 */
public class StepDataObject {
    @ApiModelProperty(position = 1,required = false,name = "步骤描述")
    public String stepDesc;
    @ApiModelProperty(position = 1,required = false,name = "步骤图片地址")
    public String stepIcon;
}
