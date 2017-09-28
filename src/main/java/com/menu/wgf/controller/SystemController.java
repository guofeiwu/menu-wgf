package com.menu.wgf.controller;

import com.menu.wgf.dto.FeedbackDateObject;
import com.menu.wgf.model.ResultMsg;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Author guofei_wu
 */
@Api
@RestController
@RequestMapping(value = "/app/system")
public class SystemController {

    @ApiOperation(value ="意见反馈",httpMethod = "POST")
    @PostMapping(value = "/feedback")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg saveFeedback(@ApiParam(value = "意见反馈对象", name = "feedbackDateObject") @RequestBody FeedbackDateObject feedbackDateObject){
        return ResultMsg.success();
    }


    @ApiOperation(value ="关于我们",httpMethod = "GET")
    @GetMapping(value = "/about")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg aboutUs(){
        // TODO: 2017/9/25  返回反馈
        return ResultMsg.success();
    }


    @ApiOperation(value ="关于我们",httpMethod = "GET")
    @GetMapping(value = "/updateVer/{oldVer}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg updateVersion(@PathVariable int oldVer){
        // TODO: 2017/9/25  返回更新信息
        return ResultMsg.success();
    }
}
