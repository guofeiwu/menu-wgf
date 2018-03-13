package com.menu.wgf.controller;

import com.alibaba.fastjson.JSONObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by guofei_wu on 2017/9/26.
 */

@RestController
@RequestMapping(value = "/app")
@Api(value = "LoginRegisterController", description = "用户登录注册")
public class LoginRegisterController {


    @Autowired
    private UserService userService;
    private static final String LOGIN_APP_PARAM_EXAMPLE = "{\n" +
            "    \"phone\":\"phone\",\n" +
            "    \"password\":\"password\"\n" +
            "}";
    private static final String REGISTER_APP_PARAM_EXAMPLE = "{\n" +
            "    \"phone\":\"phone\",\n" +
            "    \"password\":\"password\"\n" +
            "}";

    private static final String MODIFY_PHONE_PARAM_EXAMPLE = "{\n" +
            "    \"oldPhone\":\"oldPhone\",\n" +
            "    \"oldPhone\":\"oldPhone\"\n" +
            "}";

    @ApiOperation(value = "APP登录", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = LOGIN_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "/login")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg loginApp(@RequestBody Map param){

        return userService.login(param);
    }


    @ApiOperation(value = "用户注册", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = REGISTER_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "/register")
    @ApiResponses(@ApiResponse(code = 500,message = "用户注册失败",response = Integer.class))
    public ResultMsg register(@RequestBody Map param){
        return userService.register(param);
    }

    @ApiOperation(value = "短信快捷登录", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "登录的手机号码", dataType = "string", paramType = "path", required = true)
    })
    @PostMapping(value = "/{phone}")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg smsLoginApp(@PathVariable(value = "phone") String phone){
        return userService.smsLogin(phone);
    }



    @ApiOperation(value = "用户修改（忘记）密码", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = REGISTER_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "/modifyPassword")
    @ApiResponses(@ApiResponse(code = 500,message = "修改密码失败",response = Integer.class))
    public ResultMsg modifyPassword(@RequestBody Map param){
        return userService.modifyPassword(param);
    }
}
