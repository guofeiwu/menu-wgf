package com.menu.wgf.controller;

import com.alibaba.fastjson.JSONObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.Test;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author guofei_wu
 * @Date 2017/9/19 9:26
 */
@RestController
@RequestMapping(value = "/login")
@Api(value = "LoginController", description = "登录管理")
public class LoginController {
    private static final String LOGIN_APP_PARAM_EXAMPLE = "{\n" +
            "    \"userName\":\"userName\",\n" +
            "    \"password\":\"password\"\n" +
            "}";

    @ApiOperation(value = "APP登录", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = LOGIN_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    //,produces = {"application/json;charset=UTF-8"}
    @PostMapping(value = "")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg loginApp(@RequestBody Map param){
        String username = (String) param.get("userName");
        String password = (String) param.get("password");
        if(username.equals("app")){
            //return "login failed";
            return ResultMsg.failed();
        }
        //return "login success";
        return ResultMsg.success();
    }

}
