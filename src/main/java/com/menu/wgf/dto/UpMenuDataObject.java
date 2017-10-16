package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
public class UpMenuDataObject {
    @ApiModelProperty(value = "菜谱名称",position = 1,required = true)
    public String menuName;
    @ApiModelProperty(value = "菜谱描述",position = 1,required = true)
    public String menuDesc;
    @ApiModelProperty(value = "菜谱父类型",position = 1,required = true)
    public Integer menuType;
    @ApiModelProperty(value = "菜谱子类型",position = 1,required = true)
    public Integer menuTypeSun;
}
