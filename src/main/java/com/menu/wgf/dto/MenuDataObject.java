package com.menu.wgf.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 菜谱dto
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
    @ApiModelProperty(value = "菜谱对应的步骤",position =  2,required = false)
    public List<StepDataObject> steps;
    @ApiModelProperty(value = "菜谱对应的材料",position =  2,required = false)
    public List<Map<String,Object>> materials ;

    @ApiModelProperty(value = "点赞总数",position =  2,required = false)
    public int likeTotal;
    @ApiModelProperty(value = "评论总数",position =  2,required = false)
    public int commentTotal;
    @ApiModelProperty(value = "收藏总数",position =  2,required = false)
    public int collectTotal;
    @ApiModelProperty(value = "当前用户点赞",position =  2,required = false)
    public int currentLike;
    @ApiModelProperty(value = "当前用户收藏",position =  2,required = false)
    public int currentCollect;
    @ApiModelProperty(value = "当前用户点赞的主键",position =  2,required = false)
    public int likePkId;
    @ApiModelProperty(value = "当前用户收藏的主键",position =  2,required = false)
    public int collectPkId;






}
