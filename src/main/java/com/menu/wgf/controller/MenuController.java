package com.menu.wgf.controller;


import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.dto.MenuContentDataObject;
import com.menu.wgf.dto.UpMenuDataObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.MenuService;
import com.menu.wgf.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author guofei_wu
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


    @ApiOperation(value ="上传菜谱封面图片",httpMethod = "POST")
    @PostMapping(value = "/upCover")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
//    @ApiParam(value = "上传菜谱dto",name ="upMenuDataObject",required = true)
//    @RequestBody  UpMenuDataObject upMenuDataObject,
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuName",value = "菜谱名称",paramType = "query",dataType = "string",required = true),
            @ApiImplicitParam(name = "menuDesc",value = "菜谱描述",paramType = "query",dataType = "string",required = true),
            @ApiImplicitParam(name = "menuType",value = "菜谱类型",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "menuTypeSun",value = "菜谱子类型",paramType = "query",dataType = "int",required = true)
    })
    public ResultMsg upMenuCover(@RequestParam(value = "menuName") String menuName,@RequestParam(value = "menuDesc")
            String menuDesc,@RequestParam(value = "menuType")Integer menuType,
                                 @RequestParam(value = "menuTypeSun")Integer menuTypeSun,
           @ApiParam(value = "菜谱封面图", name = "cover") @RequestParam(value = "cover") MultipartFile cover){
        return menuService.uploadMenuCover(menuName,menuDesc,menuType,menuTypeSun,cover);
        //return null;
    }

    @ApiOperation(value ="上传菜谱封面图片",httpMethod = "POST")
    @PostMapping(value = "/upCoverTwo")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg upMenuCover(@ApiParam(value = "菜谱封面图", name = "cover") @RequestParam(value = "cover") MultipartFile cover){
        return menuService.uploadMenuCover(cover);
    }

    @ApiOperation(value = "上传菜谱(多张图片)", httpMethod = "POST")
    @PostMapping(value = "/upStepPicture")
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadMenu(@ApiParam(value = "http请求", name = "stepPicture", required = true)
                                    @RequestParam(value = "stepPicture") List<MultipartFile> stepPicture) {
        return menuService.upStepPicture(stepPicture);
    }



    @ApiOperation(value ="获取用户收藏的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/collect/user/{pageNo}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getUserCollectMenuList(@PathVariable(value = "pageNo") Integer pageNo){
        return menuService.getUserCollectMenuList(pageNo);
    }

    @ApiOperation(value = "上传菜谱内容", httpMethod = "POST")
    @PostMapping(value = "/upContent")
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg upMenuContent(@ApiParam(value = "菜谱内容dto" ,name = "menuContentDataObject",required = true)
                                   @RequestBody MenuContentDataObject menuContentDataObject) {
        return menuService.upMenuContent(menuContentDataObject);
    }



    @ApiOperation(value ="获取用户发布的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/user/{pageNo}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getUserMenuList(@PathVariable("pageNo") Integer pageNo){
        return menuService.getUserMenuList(pageNo);
    }

    @ApiOperation(value ="获取用户评论的菜谱列表",httpMethod = "GET")
    @GetMapping(value = "/comment/user/{pageNo}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getUserCommentMenuList(@PathVariable("pageNo") Integer pageNo){
        return menuService.getUserCommentMenuList(pageNo);
    }

    @ApiOperation(value ="判断当前用户在改菜谱是否还有评论",httpMethod = "GET")
    @GetMapping(value = "/comment/currentUser/{menuPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg judgeHasComment(@PathVariable("menuPkId") Integer menuPkId){
        return menuService.judgeHasComment(menuPkId);
    }

    @ApiOperation(value ="增加美食足迹",httpMethod = "GET")
    @GetMapping(value = "/record/{menuPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuPkId",value = "菜谱主键",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg addUserMenuRecord(@PathVariable("menuPkId") Integer menuPkId){
        return menuService.addUserMenuRecord(menuPkId);
    }

    @ApiOperation(value ="获取用户美食足迹",httpMethod = "GET")
    @GetMapping(value = "/getRecord/{pageNo}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getUserMenuRecordList(@PathVariable("pageNo") Integer pageNo){
        return menuService.getUserMenuRecord(pageNo);
    }




}
