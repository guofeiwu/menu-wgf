package com.menu.wgf.controller;

import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.SystemService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author guofei_wu
 */
@Api(value = "SystemController",description = "系统接口")
@RestController
@RequestMapping(value = "/app/system")
public class SystemController {
    private static final String FEEDBACK_BODY = "{\n" +
            " \"feedback\":\"feedbackContent\"\n" +
            "}";
    @Autowired
    private SystemService systemService;

    @ApiOperation(value ="意见反馈",httpMethod = "POST")
    @PostMapping(value = "/feedback")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg saveFeedback(@ApiParam(value = FEEDBACK_BODY, name = "map")
                                      @RequestBody Map map){
        return systemService.feedback(map);
    }


    @ApiOperation(value ="关于我们",httpMethod = "GET")
    @GetMapping(value = "/about")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg aboutUs(){
        // TODO: 2017/9/25  返回反馈
        return ResultMsg.success();
    }


    @ApiOperation(value ="版本更新",httpMethod = "GET")
    @GetMapping(value = "/updateVer/{oldVer}")
    @ApiResponses(@ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class))
    public ResultMsg updateVersion(@PathVariable int oldVer){
        // TODO: 2017/9/25  返回更新信息
        return ResultMsg.success();
    }
}
