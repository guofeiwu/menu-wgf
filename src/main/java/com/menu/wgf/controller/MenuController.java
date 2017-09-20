package com.menu.wgf.controller;

import com.menu.wgf.model.MenuConditionDataObject;
import com.menu.wgf.model.ResultMsg;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Author guofei_wu
 * @Date 2017/9/20 17:07
 */
@RestController
@RequestMapping(value = "/menu")
@Api(value = "MenuController",description = "菜谱管理")
public class MenuController {


//    @ApiOperation(value ="获取菜谱列表",httpMethod = "GET")
//    @GetMapping(value = "")
//    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageSize",value = "每页的数量",paramType = "query",dataType = "int",required = true),
//            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "query",dataType = "int",required = true),
//            @ApiImplicitParam(name = "keyword",value = "关键字",paramType = "query",dataType = "string",required = false)
//
//    })
//    public ResultMsg getMenuList(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageNo") Integer pageNo,@RequestParam("keyword") String keyword){
//        return ResultMsg.success().addContent("menuList",null);
//    }


    @ApiOperation(value ="获取菜谱列表",httpMethod = "GET")
    @GetMapping(value = "")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuConditionDataObject",value = "获取菜谱的条件",paramType = "body",required = true)
    })
    public ResultMsg getMenuList(@RequestBody MenuConditionDataObject menuConditionDataObject){
        return ResultMsg.success().addContent("menuList",null);
    }



    @ApiOperation(value ="获取用户收藏的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户的主键",paramType = "path",required = true)
    })
    public ResultMsg getUserCollectMenuList(@PathVariable Integer userPkId){
        return ResultMsg.success().addContent("collectMenuList",null);
    }


}
