package com.menu.wgf.controller;

import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.utils.IOUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author guofei_wu
 * @Date 2017/9/25 9:50
 */
@Api(value = "ShaiController",description = "晒一晒管理")
@RestController
@RequestMapping("/shai")
public class ShaiController {

    @ApiOperation(value ="评论晒一晒",httpMethod = "POST")
    @PostMapping(value = "/comment")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "shaiPkId",value = "晒晒主键",paramType = "query",dataType = "int",required = true),
            @ApiImplicitParam(name = "commentContent",value = "评论的内容",paramType = "query",dataType = "string",required = true)
    })
    public ResultMsg addCommentShai(@RequestParam("userPkId") int userPkId, @RequestParam("shaiPkId") int shaiPkId, @RequestParam("commentContent") String commentContent){
        System.out.println("userId:"+userPkId+",shaiPkId:"+shaiPkId+",commentContent:"+commentContent);
        return ResultMsg.success();
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
    @GetMapping(value = "/comment/{shaiPkId}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shaiPkId",value = "晒晒主键",paramType = "path",dataType = "int",required = true),
    })
    public ResultMsg getCommentsShai(@PathVariable("shaiPkId")int shaiPkId) {
        System.out.println("shaiPkId:" + shaiPkId);
        return ResultMsg.success();
    }


    @ApiOperation(value = "上传晒一晒", httpMethod = "POST")
    @PostMapping(value = "/{userPkId}/{type}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadShaiIcon(@PathVariable(value = "userPkId") Integer userPkId,@PathVariable("type") Integer type,
                                @ApiParam(value = "晒一晒", name = "shaiPicture") @RequestParam("shaiPicture") MultipartFile shaiPicture) {
        return IOUtils.uploadFile(userPkId,type,shaiPicture);
    }
}
