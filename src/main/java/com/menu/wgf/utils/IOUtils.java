package com.menu.wgf.utils;

import com.menu.wgf.Constants;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

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
    public static ResultMsg uploadFile(Integer userPkId,Integer type,
                                   MultipartFile multipartFile){
        // TODO: 2017/9/20 根据用户主键获取用户名
        String userName = "user"+userPkId;
        String fileName = multipartFile.getOriginalFilename();
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = multipartFile.getInputStream();
            bis = new BufferedInputStream(is);
            //TODO 之后可以更改路径
            String setFilePath = null;
             switch (type){
                 case Constants.FILE_TYPE_SHAI://晒一晒
                     setFilePath = "G://uploadFiles//menu-wgf//shaiyishai//" + userName;//用户的头像的文件夹
                     break;
                 case Constants.FILE_TYPE_ICON://头像
                     setFilePath = "G://uploadFiles//menu-wgf//icon//" + userName;//用户的头像的文件夹
                     break;
                 case Constants.FILE_TYPE_MENU://菜谱
                     setFilePath = "G://uploadFiles//menu-wgf//menu//" + userName;//用户的头像的文件夹
                     break;
             }
            File userFile = new File(setFilePath);
            if (!userFile.exists()){
                userFile.mkdirs();
            }

            //TODO 之后可以将这个路径写入数据库
            String filePath = setFilePath+File.separator+fileName;//文件的路径
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
        return ResultMsg.success();
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
}
