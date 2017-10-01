package com.menu.wgf.util;

import com.menu.wgf.Constants;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author guofei_wu
 */
public class IOUtils {


    /**
     * 关闭流
     * @param bos
     * @param bis
     */
    public static void colse(BufferedOutputStream bos, BufferedInputStream bis){
    }


    /**
     * 用户上传文件(单个上传)
     * @param userPkId 用户主键
     * @param type 文件所属类别
     * @param multipartFile 文件
     * @return ResultMsg
     */
    public static Map uploadFile(Integer userPkId,Integer type,Integer currentIndex,
                                   MultipartFile multipartFile){

        Map<String,Object> map = new HashMap();

        String userName = "user"+userPkId;
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = "user"+(++currentIndex);
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = multipartFile.getInputStream();
            bis = new BufferedInputStream(is);
            //TODO 之后可以更改路径
            String setFilePath = null;
             switch (type){
                 case Constants.FILE_TYPE_SHAI://晒一晒
                     // TODO: 2017/10/1 需要更换地址
                     setFilePath = Constants.BASE_URL_FILE_ICON+ userName;//用户的晒一晒的文件夹
                     break;
                 case Constants.FILE_TYPE_ICON://头像
                     setFilePath = Constants.BASE_URL_FILE_ICON;//用户的头像的文件夹
                     break;
                 case Constants.FILE_TYPE_MENU://菜谱
                     setFilePath = Constants.BASE_URL_FILE_MENUS + userName;//用户的头像的文件夹
                     break;
             }
            File userFile = new File(setFilePath);
            if (!userFile.exists()){
                userFile.mkdirs();
            }
            String filePath = setFilePath+userName+File.separator+fileName+suffix;//文件的路径
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
            map.put("currentIndex",0);
        } finally {
            try {
                if (bis != null){
                    bis.close();
                }
                if(bos != null)
                {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("currentIndex",currentIndex);
        map.put("suffix",suffix);

        return map;
    }

    /**
     * 多文件上传
     * @param userPkId 用户主键
     * @param type 类型
     * @param request
     * @return
     */
    public static ResultMsg multifileUpload(Integer userPkId,Integer type,HttpServletRequest request){

        // TODO: 2017/9/20 根据用户主键获取用户名
        String userName = "user"+userPkId;

        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream bos = null;


        String setFilePath = null;
        switch (type){
            case Constants.FILE_TYPE_SHAI://晒一晒
                setFilePath = "G://uploadFiles//menu-wgf//shaiyishai//" + userName;//用户的头像的文件夹
                break;
            case Constants.FILE_TYPE_MENU://菜谱
                setFilePath = "G://uploadFiles//menu-wgf//menu//" + userName;//用户的头像的文件夹
                break;
        }
        File userFile = new File(setFilePath);
        if (!userFile.exists()){
            userFile.mkdirs();
        }

        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            String fileName = file.getOriginalFilename();
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    bos = new BufferedOutputStream(new FileOutputStream(new File(setFilePath+File.separator+fileName)));
                    bos.write(bytes);
                    bos.close();
                } catch (Exception e) {
                    return ResultMsg.failed();
                }finally {
                    if(bos!=null){
                        try {
                            bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                return ResultMsg.failed();
            }
        }
        return ResultMsg.success();

    }





    public static void downloadIcon(){

    }
}
