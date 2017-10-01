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
 * @Author guofei_wu
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
            "    \"oldPhone\":\"oldPhone\",\n" +
            "    \"oldPhone\":\"oldPhone\"\n" +
            "}";




    @ApiOperation(value = "修改手机号码", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = MODIFY_PHONE_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "/modifyPhone")
    @ApiResponses(@ApiResponse(code = 500,message = "修改手机号码失败",response = Integer.class))
    public ResultMsg modifyPhone(@RequestBody Map param){
        return ResultMsg.success();
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
//    @ApiImplicitParams({
//            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path")
//    })
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


    /**
     * 现在暂时没用
     * @param response
     * @param userPkId
     * @param pictureName
     * @return
     */
    @ApiOperation(value = "下载用户头像",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "/{userName}/download")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",required = true,paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "pictureName",value = "图片名称",required = true,paramType = "query",dataType = "string")
    })
    public ResultMsg downloadPicture(HttpServletResponse response,@PathVariable("userPkId") int userPkId,@RequestParam("pictureName") String pictureName){
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + pictureName);
//        // TODO: 2017/9/25  根据userPkId 获取用户名
//        String userName = null;
        BufferedInputStream bis = null;

        File file = new File("D://Work//idea//menu-wgf//file//user"+jwtUtil.getLoginPkid()+File.separator+pictureName);
        if(!file.exists()){
            return ResultMsg.failed();//文件不存在直接返回
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            OutputStream os = response.getOutputStream();
            int len;
            byte buff[] = new byte[1024];
            while ((len=bis.read(buff))!=-1){
                os.write(buff,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResultMsg.success();
    }


    @ApiOperation(value = "用户签到",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "/sign")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    public ResultMsg userSign(){
        return userService.userSign(jwtUtil.getLoginPkid());
    }









//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ApiOperation(value = "上传文件到指定的路径下", response = String.class, notes = "上传文件到指定的路径下")
//    public String cpicUpload(@ApiParam(value = "文件名称") @RequestParam(required = false) String name,
//                             @ApiParam(value = "文件", required = true) @RequestParam(required = true) MultipartFile file) {
//        return "HelloWorld";
//    }

}
