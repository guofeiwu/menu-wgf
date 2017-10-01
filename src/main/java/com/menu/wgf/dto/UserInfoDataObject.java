package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author guofei_wu
 * @Date 2017/9/25 11:29
 */
public class UserInfoDataObject {
    @ApiModelProperty(position = 1,required = false,name = "用户主键")
    public int userPkId;
    @ApiModelProperty(position = 1,required = false,name = "用户名称")
    public String name;
    @ApiModelProperty(position = 1,required = false,name = "手机号码")
    public String phone;
    @ApiModelProperty(position = 1,required = false,name = "性别")
    public Integer sex;

    @ApiModelProperty(position = 1,required = false,name = "头像")
    public String icon;

    @ApiModelProperty(position = 1,required = false,name = "生日")
    public String birthday;
    @ApiModelProperty(position = 1,required = false,name = "积分")
    public int point;
    @ApiModelProperty(position = 1,required = false,name = "等级")
    public String level;//等级
    @ApiModelProperty(position = 1,required = false,name = "签到")
    public int sign;//签到
}
