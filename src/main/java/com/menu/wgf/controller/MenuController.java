package com.menu.wgf.controller;

import com.menu.wgf.dto.MenuConditionDataObject;
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
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuConditionDataObject",value = "获取菜谱的条件",paramType = "body",required = true)
    })
    public ResultMsg getMenuList(@RequestBody MenuConditionDataObject menuConditionDataObject){
        return ResultMsg.success().addContent("menuList",null);
    }




    @ApiOperation(value ="评论菜谱",httpMethod = "POST")
    @PostMapping(value = "/comment")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "commentContent",value = "评论的内容",paramType = "query",dataType = "string",required = true)
    })
    public ResultMsg addCommentMenu(@RequestParam("userPkId") int userPkId,@RequestParam("menuPkId") int menuPkId,@RequestParam("commentContent") String commentContent){
        System.out.println("userId:"+userPkId+",menuPkId:"+menuPkId+",commentContent:"+commentContent);
        return ResultMsg.success();
    }


    @ApiOperation(value ="删除菜谱评论",httpMethod = "DELETE")
    @DeleteMapping(value = "/comment/{commentPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentPkId",value = "评论主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg deleteCommentMenu(@PathVariable("commentPkId") int commentPkId){
        System.out.println("commentPkId:"+commentPkId);
        return ResultMsg.success();
    }


    @ApiOperation(value ="获取菜谱对应的评论",httpMethod = "GET")
    @GetMapping(value = "/comment/{menuPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg getCommentsMenu(@PathVariable int menuPkId){
        System.out.println("menuPkId:"+menuPkId);
        return ResultMsg.success();
    }


    @ApiOperation(value ="获取用户评论的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/comment/user/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户的主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页返回的大小",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "query",dataType = "int",required = true)
    })
    public ResultMsg getUserCommentMenuList(@PathVariable Integer userPkId,@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("pageNo") Integer pageNo){
        return ResultMsg.success().addContent("commentMenuList",null);
    }







    @ApiOperation(value ="收藏菜谱",httpMethod = "GET")
    @GetMapping(value = "/collect")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "query",dataType = "int",required = true),
    })
    public ResultMsg collectMenu(@RequestParam("userPkId") int userPkId,@RequestParam("menuPkId") int menuPkId){
        System.out.println("userId:"+userPkId+",menuPkId:"+menuPkId);
        return ResultMsg.success();
    }


    @ApiOperation(value ="取消收藏菜谱",httpMethod = "DELETE")
    @DeleteMapping(value = "/collect/{collectPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collectPkId",value = "收藏主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg collectMenu(@PathVariable int collectPkId){
        System.out.println("collectPkId:"+collectPkId);
        return ResultMsg.success();
    }



    @ApiOperation(value ="获取用户收藏的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/collect/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户的主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页返回的大小",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "query",dataType = "int",required = true)
    })
    public ResultMsg getUserCollectMenuList(@PathVariable Integer userPkId,@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("pageNo") Integer pageNo){
        return ResultMsg.success().addContent("collectMenuList",null);
    }
}
