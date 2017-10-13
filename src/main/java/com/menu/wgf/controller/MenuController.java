package com.menu.wgf.controller;


import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.MenuService;
import com.menu.wgf.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author guofei_wu
 */
@RestController
@RequestMapping(value = "/app/menu")
@Api(value = "MenuController",description = "菜谱管理")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @ApiOperation(value ="获取菜谱列表",httpMethod = "POST")
    @PostMapping(value = "/all")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg getMenuList(@ApiParam(value = "获取菜谱条件dto",name = "menuConditionDataObject",required = true)
                                     @RequestBody MenuConditionDataObject menuConditionDataObject){
        return menuService.getMenuList(menuConditionDataObject);
    }



    @ApiOperation(value ="获取菜谱详情",httpMethod = "GET")
    @GetMapping(value = "/detail/{menuPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg getMenuDetail(@PathVariable(value = "menuPkId") int menuPkId){
        return menuService.getMenuDetail(menuPkId);
    }



    @ApiOperation(value ="获取菜谱对应的评论",httpMethod = "GET")
    @GetMapping(value = "/comment/{menuPkId}/page/{pageNo}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value ="第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getCommentsMenu(@PathVariable int menuPkId,@PathVariable(value = "pageNo") int pageNo){
        return menuService.getMenuCommentList(menuPkId,pageNo);
    }

    @ApiOperation(value ="点赞菜谱",httpMethod = "GET")
    @GetMapping(value = "/like/{menuPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg likeMenu(@PathVariable("menuPkId") int menuPkId){
        return menuService.likeMenu(menuPkId);
    }


    @ApiOperation(value ="取消点赞菜谱",httpMethod = "GET")
    @GetMapping(value = "/dislike/{likePkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "likePkId",value = "点赞主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg dislikeMenu(@PathVariable("likePkId") int menuPkId){
        return menuService.dislikeMenu(menuPkId);
    }


    @ApiOperation(value ="收藏菜谱",httpMethod = "GET")
    @GetMapping(value = "/collect/{menuPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg collectMenu(@PathVariable("menuPkId") int menuPkId){
        return menuService.collectMenu(menuPkId);
    }


    @ApiOperation(value ="取消收藏菜谱",httpMethod = "GET")
    @GetMapping(value = "/notCollect/{collectPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "collectPkId",value = "收藏主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg notCollectMenu(@PathVariable int collectPkId){
        return menuService.notCollectMenu(collectPkId);
    }


    @ApiOperation(value ="评论菜谱",httpMethod = "POST")
    @PostMapping(value = "/comment")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg addCommentMenu(@ApiParam(value = "评论对象dto" ,name = "commentDataObject",required = true)@RequestBody CommentDataObject commentDataObject){

        return menuService.commentMenu(commentDataObject);
    }

    @ApiOperation(value ="删除菜谱评论",httpMethod = "DELETE")
    @DeleteMapping(value = "/comment/{commentPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentPkId",value = "评论主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg deleteCommentMenu(@PathVariable("commentPkId") int commentPkId){
        return menuService.deleteCommentMenu(commentPkId);
    }





    @ApiOperation(value ="获取banner菜谱",httpMethod = "GET")
    @GetMapping(value = "/banner")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg getMenuBanners(){
        return menuService.getBannerMenu();
    }









    @ApiOperation(value ="获取用户评论的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/comment/user/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户的主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页返回的大小",paramType = "com/menu/wgf/query",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "com/menu/wgf/query",dataType = "int",required = true)
    })
    public ResultMsg getUserCommentMenuList(@PathVariable Integer userPkId,@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("pageNo") Integer pageNo){
        return ResultMsg.success().addContent("commentMenuList",null);
    }



    @ApiOperation(value ="获取用户收藏的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/collect/user/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户的主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页返回的大小",paramType = "com/menu/wgf/query",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "com/menu/wgf/query",dataType = "int",required = true)
    })
    public ResultMsg getUserCollectMenuList(@PathVariable Integer userPkId,@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("pageNo") Integer pageNo){
        return ResultMsg.success().addContent("collectMenuList",null);
    }





    @ApiOperation(value = "上传菜谱(单张图片)", httpMethod = "POST")
    @PostMapping(value = "/one/{userPkId}/{type}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadMenu(@PathVariable(value = "userPkId") Integer userPkId,@PathVariable("type") Integer type,
                                    @ApiParam(value = "菜谱", name = "menu") @RequestParam("menu") MultipartFile menu) {
        //return IOUtils.uploadFile(userPkId,type,menu);
        return null;
    }


    @ApiOperation(value = "上传菜谱(多张图片)", httpMethod = "POST")
    @PostMapping(value = "/multi/{userPkId}/{type}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadMenu(@PathVariable(value = "userPkId") Integer userPkId,@PathVariable("type") Integer type,
                                    @ApiParam(value = "菜谱", name = "menu") @RequestParam("menu") HttpServletRequest menu) {
        return IOUtils.multifileUpload(userPkId,type,menu);
    }
}
