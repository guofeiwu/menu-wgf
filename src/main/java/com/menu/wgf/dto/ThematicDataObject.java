package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author guofei_wu
 * @email guofei_wu@163.com
 */
public class ThematicDataObject {
    @ApiModelProperty(value = "专题的图片的链接",position = 1,required = true)
    public String thematicPictureUrl;
    @ApiModelProperty(value = "专题名称",position =1,required = true)
    public String thematicName;
}
