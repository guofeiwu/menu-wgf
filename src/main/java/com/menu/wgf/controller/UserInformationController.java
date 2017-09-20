package com.menu.wgf.controller;

import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.Test;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 * @Author guofei_wu
 * @Date 2017/9/20 10:08
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(value = "UserInformationController", description = "用户信息管理")
public class UserInformationController {

    @ApiOperation(value = "用户上传头像", httpMethod = "POST")
    @PutMapping(value = "/icon/{userPkId}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadIcon(@PathVariable(value = "userPkId") Integer userPkId, @ApiParam(value = "用户头像", name = "icon") @RequestParam("icon") MultipartFile icon) {
        // TODO: 2017/9/20 根据用户主键获取用户名
        String userName = null;
        String fileName = icon.getOriginalFilename();
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = icon.getInputStream();
            bis = new BufferedInputStream(is);
            //TODO 之后可以更改路径
            String userPath = "G://userInfo//" + userName;//用户的头像的文件夹
            File userFile = new File(userPath);

            if (!userFile.exists()){
                userFile.mkdir();
            }
            //TODO 之后可以将这个路径写入数据库
            String filePath = userPath+File.separator+fileName;//用户头像路径
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte buff[] = new byte[1024];
            int len;
            while ((len = bis.read(buff))!=-1){
                bos.write(buff,0,len);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return ResultMsg.failed();
        } finally {
            try {
                if (bis!=null){
                    bis.close();
                }
                if(bos!=null)
                {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultMsg.success().addContent("userName",userName);
    }



    @ApiOperation(value = "获取用户的信息",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path")
    })
    public ResultMsg getUserInfo(@PathVariable Integer userPkId){


        return ResultMsg.success().addContent("userInfo",null);
    }



    @ApiOperation(value = "修改用户的信息",httpMethod = "PUT",response = ResultMsg.class,notes = "修改了除了头像之外的信息")
    @PutMapping(value = "/{userPkId}")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户信息DTO", name = "test", required = true),
    })
    // TODO: 2017/9/20  这里需要修改dto
    public ResultMsg modifyUserInfo(@RequestBody Test test){

        return ResultMsg.success();
    }













//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ApiOperation(value = "上传文件到指定的路径下", response = String.class, notes = "上传文件到指定的路径下")
//    public String cpicUpload(@ApiParam(value = "文件名称") @RequestParam(required = false) String name,
//                             @ApiParam(value = "文件", required = true) @RequestParam(required = true) MultipartFile file) {
//        return "HelloWorld";
//    }

}
