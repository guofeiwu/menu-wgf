package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 * @Date 2017/9/20 17:38
 * 获取菜谱的条件DTO
 */

public class MenuConditionDataObject {
    @ApiModelProperty(value = "关键字",position = 2,required = false)
    public String keyword;
    @ApiModelProperty(value = "每页大小",position = 2,required = true)
    public int pageSize;
    @ApiModelProperty(value = "第几页",position = 2,required = true)
    public int pageNo;
    @ApiModelProperty(value = "菜谱类型",position = 2,required = false)
    public int type;
}
