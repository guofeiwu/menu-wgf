package com.menu.wgf.controller;

import com.alibaba.fastjson.JSONObject;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.Test;
import com.menu.wgf.util.IOUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;


/**
 * @Author guofei_wu
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "UserController", description = "用户管理")
public class UserController {


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

    @ApiOperation(value = "APP登录", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = LOGIN_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg loginApp(@RequestBody Map param){
        String username = (String) param.get("userName");
        String password = (String) param.get("password");
        if(username.equals("app")){
            return ResultMsg.failed();
        }
        return ResultMsg.success();
    }


    @ApiOperation(value = "用户注册", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = REGISTER_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "")
    @ApiResponses(@ApiResponse(code = 500,message = "用户注册失败",response = Integer.class))
    public ResultMsg register(@RequestBody Map param){
        return ResultMsg.success();
    }

    @ApiOperation(value = "用户修改（忘记）密码", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = REGISTER_APP_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg modifyPassword(@RequestBody Map param){
        return ResultMsg.success();
    }


    @ApiOperation(value = "修改手机号码", httpMethod = "POST",response = JSONObject.class, notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = MODIFY_PHONE_PARAM_EXAMPLE, dataType = "map", paramType = "body", required = true)
    })
    @PostMapping(value = "")
    @ApiResponses(@ApiResponse(code = 500,message = "用户登录失败",response = Integer.class))
    public ResultMsg modifyPhone(@RequestBody Map param){
        return ResultMsg.success();
    }


    @ApiOperation(value = "用户上传头像", httpMethod = "PUT")
    @PutMapping(value = "/icon/{userPkId}")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户主键", name = "userPkId", required = true, dataType = "int", paramType = "path"),
    })
    @ApiResponse(code = 500,message = "服务器相应出错",response = Integer.class)
    public ResultMsg uploadIcon(@PathVariable(value = "userPkId") Integer userPkId, @ApiParam(value = "用户头像", name = "icon") @RequestParam("icon") MultipartFile icon) {
        // TODO: 2017/9/20 根据用户主键获取用户名
        String userName = "wgf";
        String fileName = icon.getOriginalFilename();
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = icon.getInputStream();
            bis = new BufferedInputStream(is);
            //TODO 之后可以更改路径
            String userPath = "D://Work//idea//menu-wgf//" + userName;//用户的头像的文件夹
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
            IOUtils.colse(bos,bis);
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


    @ApiOperation(value = "下载用户头像",httpMethod = "GET",response = ResultMsg.class)
    @GetMapping(value = "/{userName}/download")
    @ApiResponse(code = 500,message = "服务器响应出错",response = Integer.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPkId",value = "用户主键",required = true,paramType = "path",dataType = "string"),
            @ApiImplicitParam(name = "pictureName",value = "图片名称",required = true,paramType = "query",dataType = "string")
    })
    public ResultMsg downloadPicture(HttpServletResponse response,@PathVariable("userPkId") int userPkId,@RequestParam("pictureName") String pictureName){
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + pictureName);
        // TODO: 2017/9/25  根据userPkId 获取用户名
        String userName = null;
        BufferedInputStream bis = null;

        File file = new File("D://Work//idea//menu-wgf//file//"+userName+File.separator+pictureName);
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













//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ApiOperation(value = "上传文件到指定的路径下", response = String.class, notes = "上传文件到指定的路径下")
//    public String cpicUpload(@ApiParam(value = "文件名称") @RequestParam(required = false) String name,
//                             @ApiParam(value = "文件", required = true) @RequestParam(required = true) MultipartFile file) {
//        return "HelloWorld";
//    }

}
