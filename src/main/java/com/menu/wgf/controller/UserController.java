package com.menu.wgf.controller;

import com.alibaba.fastjson.JSONObject;
import com.menu.wgf.Constants;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.Test;
import com.menu.wgf.service.UserService;
import com.menu.wgf.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;


/**
 * @author guofei_wu
 */
@RestController
@RequestMapping(value = "/app/user")
@Api(value = "UserController", description = "用户管理")
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    private static final String LOGIN_APP_PARAM_EXAMPLE = "{\n" +
            "    \"userName\":\"userName\",\n" +
            "    \"password\":\"password\"\n" +
            "}";
    private static final String REGISTER_APP_PARAM_EXAMPLE = "{\n" +
            "    \"phone\":\"phone\",\n" +
            "    \"password\":\"password\"\n" +
            "}";

    private static final String MODIFY_PHONE_PARAM_EXAMPLE = "{\n" +
            "    \"newPhone\":\"newPhone\"\n" +
            "}";




    @ApiOperation(value = "修改手机号码", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = MODIFY_PHONE_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "/modifyPhone")
    @ApiResponses(@ApiResponse(code = 500,message = "修改手机号码失败",response = Integer.class))
    public ResultMsg modifyPhone(@RequestBody Map param){
        return userService.modifyPhone(param);
    }


    @ApiOperation(value = "用户上传头像", httpMethod = "PUT")
    @PutMapping(value = "/icon")
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadIcon(@ApiParam(value = "用户头像", name = "icon") @RequestParam("icon") MultipartFile icon) {
       return userService.uploadUserIcon(jwtUtil.getLoginPkid(), Constants.FILE_TYPE_ICON,icon);
    }



    @ApiOperation(value = "获取用户的信息",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    public ResultMsg getUserInfo(){
        return userService.getUserInfo(jwtUtil.getLoginPkid());
    }



    @ApiOperation(value = "修改用户的信息",httpMethod = "PUT",response = ResultMsg.class,notes = "修改了除了头像之外的信息")
    @PutMapping(value = "")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    public ResultMsg modifyUserInfo(@ApiParam(name = "userInfoDataObject",value = "用户信息DTO",required = true)
                                        @RequestBody UserInfoDataObject userInfoDataObject){
        return userService.modifyUserInfo(jwtUtil.getLoginPkid(),userInfoDataObject);
    }



    @ApiOperation(value = "用户签到",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "/sign/{flag}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "flag", value = "1表示判断是否已经签到，2表示进行签到操作", dataType = "int", paramType = "path", required = true)
    })
    public ResultMsg userSign(@PathVariable("flag") int flag){
        return userService.userSign(flag);
    }


//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ApiOperation(value = "上传文件到指定的路径下", response = String.class, notes = "上传文件到指定的路径下")
//    public String cpicUpload(@ApiParam(value = "文件名称") @RequestParam(required = false) String name,
//                             @ApiParam(value = "文件", required = true) @RequestParam(required = true) MultipartFile file) {
//        return "HelloWorld";
//    }

}
