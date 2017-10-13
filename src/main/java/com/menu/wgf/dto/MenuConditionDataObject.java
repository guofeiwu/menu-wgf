package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 * @Date 2017/9/20 17:38
 * 获取菜谱的条件DTO
 */

public class MenuConditionDataObject {
    @ApiModelProperty(value = "第几页",position = 1,required = true)
    public int pageNo;
    @ApiModelProperty(value = "关键字",position = 2,required = false)
    public String keyword;
    @ApiModelProperty(value = "菜谱类型",position = 2,required = false)
    public Integer pType;
    @ApiModelProperty(value = "菜谱类型子类型",position = 2,required = false)
    public Integer sunType;
}
