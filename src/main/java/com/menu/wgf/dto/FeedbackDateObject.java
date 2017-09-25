package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 * @Date 2017/9/25 17:39
 */
public class FeedbackDateObject {
    @ApiModelProperty(value = "用户主键",position = 1,required = false)
    public int userPkId;
    @ApiModelProperty(value = "反馈内容",position = 1,required = true)
    public String content;
}
