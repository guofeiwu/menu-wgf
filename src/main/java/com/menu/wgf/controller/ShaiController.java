package com.menu.wgf.controller;

import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.ShaiService;
import com.menu.wgf.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author guofei_wu
 */
@Api(value = "ShaiController",description = "晒一晒管理")
@RestController
@RequestMapping("/app/shai")
public class ShaiController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ShaiService shaiService;

    @ApiOperation(value ="评论晒一晒",httpMethod = "POST")
    @PostMapping(value = "/comment")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg addCommentShai(@ApiParam(value = "评论对象", name = "commentDataObject") @RequestBody CommentDataObject commentDataObject){
        return shaiService.commentShai(jwtUtil.getLoginPkid(),commentDataObject);
    }


    @ApiOperation(value ="删除晒一晒评论",httpMethod = "DELETE")
    @DeleteMapping(value = "/comment/{commentPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentPkId",value = "评论主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg deleteCommentShai(@PathVariable("commentPkId") int commentPkId){
        System.out.println("commentPkId:"+commentPkId);
        return ResultMsg.success();
    }

    @ApiOperation(value ="获取晒一晒对应的评论",httpMethod = "GET")
    @GetMapping(value = "/comment/{shaiPkId}/{pageNo}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shaiPkId",value = "晒晒主键",paramType = "path",dataType = "int",required = true),
            @ApiImplicitParam(name = "pageNo",value = "获取第几页",paramType = "path",dataType = "int",required = true)
    })
    public ResultMsg getCommentsShai(@PathVariable("shaiPkId")int shaiPkId,@PathVariable("pageNo")int pageNo) {
        return shaiService.getCommentShaiList(shaiPkId,pageNo);
    }


    @ApiOperation(value = "上传晒一晒", httpMethod = "POST")
    @PostMapping(value = "/{userPkId}/{type}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadShaiIcon(@PathVariable(value = "userPkId") Integer userPkId,@PathVariable("type") Integer type,
                                @ApiParam(value = "晒一晒", name = "shaiPicture") @RequestParam("shaiPicture") MultipartFile shaiPicture) {
        //return IOUtils.uploadFile(userPkId,type,shaiPicture);
        return null;
    }

    @ApiOperation(value ="删除晒一晒",httpMethod = "DELETE")
    @DeleteMapping(value = "/{shaiPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shaiPkId",value = "晒晒主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg deleteShai(@PathVariable("shaiPkId") int shaiPkId) {

        return ResultMsg.success();
    }

    @ApiOperation(value ="获取某个用户的晒一晒",httpMethod = "GET")
    @GetMapping(value = "/{userPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg getUserShai(@PathVariable("userPkId") int userPkId) {

        return ResultMsg.success();
    }


    @ApiOperation(value ="获取所有的晒一晒",httpMethod = "GET",notes = "分页显示数据")
    @GetMapping(value = "/all/{pageNo}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "第几页",paramType = "path",dataType = "int",required = true),
    })
    // TODO: 2017/9/25 使用pageHelper
    public ResultMsg getShaiList(@PathVariable int pageNo) {
        return shaiService.getShaiList(pageNo);
    }


    @ApiOperation(value ="获取用户点赞的晒一晒",httpMethod = "GET",notes = "")
    @GetMapping(value = "/like")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg getShaiList() {
        return shaiService.getLikeShai(jwtUtil.getLoginPkid());
    }



    @ApiOperation(value ="点赞晒一晒",httpMethod = "GET",notes = "")
    @GetMapping(value = "/like/{shaiPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shaiPkId",value = "晒晒主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg likeShai(@PathVariable int shaiPkId) {
        return shaiService.likeShai(jwtUtil.getLoginPkid(),shaiPkId);
    }

    @ApiOperation(value ="取消点赞晒一晒",httpMethod = "GET",notes = "")
    @GetMapping(value = "/dislike/{likePkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "likePkId",value = "点赞主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg dislikeShai(@PathVariable int likePkId) {
        return shaiService.disLikeShai(likePkId);
    }
}
