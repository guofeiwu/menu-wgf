package com.menu.wgf.util;

import com.menu.wgf.Constants;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.menu.wgf.Constants.BASE_URL_FILE_MENUS;

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


    /**
     * 用户上传文件(单个上传)
     * @param userPkId 用户主键
     * @param type 文件所属类别
     * @param multipartFile 文件
     * @return ResultMsg
     */
    public static Map uploadFile(Integer userPkId,Integer type,Integer currentIndex,
                                   MultipartFile multipartFile){
        String filePath = null;
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
                 case Constants.FILE_TYPE_ICON://头像
                     setFilePath = Constants.BASE_URL_FILE_ICON+userName;//用户的头像的文件夹
                     break;
             }
            File userFile = new File(setFilePath);
            if (!userFile.exists()){
                userFile.mkdirs();
            }
            filePath = setFilePath+File.separator+fileName+suffix;//文件的路径
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
            colse(bos,bis);
        }
        map.put("currentIndex",currentIndex);
        map.put("suffix",suffix);
        map.put("filePath",userName+"/"+fileName+suffix);
        return map;
    }


    /**
     * 用户上传晒一晒
     * @param index 图片名字下标
     * @param multipartFile 文件
     * @return 图片地址
     */
    public static String uploadShai(int index,
                                       MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));//后缀
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        String setFilePath;
        InputStream is = null;
        try {
            is = multipartFile.getInputStream();
            bis = new BufferedInputStream(is);
            setFilePath = Constants.BASE_URL_FILE_SHAI+ "food"+index+suffix;//用户的晒一晒的文件夹

            File file = new File(setFilePath);
            FileOutputStream fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte buff[] = new byte[1024];
            int len;
            while ((len = bis.read(buff))!=-1){
                bos.write(buff,0,len);
            }
            bos.flush();
            return "food"+index+suffix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            colse(bos,bis);
        }
    }


    /**
     * 上传菜谱封面
     * @param multipartFile
     */
    public static String uploadMenuCover(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));//后缀
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        InputStream is = null;
        String filePath;
        try {

            is = multipartFile.getInputStream();
            bis = new BufferedInputStream(is);
            filePath = BASE_URL_FILE_MENUS;//用户菜谱文件夹

            File file = new File(filePath);
            if (!file.exists()){
                file.mkdirs();
            }
            long time = System.currentTimeMillis();
            File outputFile = new File(filePath+File.separator+time+suffix);
            FileOutputStream fos = new FileOutputStream(outputFile);
            bos = new BufferedOutputStream(fos);

            byte buff[] = new byte[1024];
            int len;
            while ((len = bis.read(buff))!=-1){
                bos.write(buff,0,len);
            }
            bos.flush();
            return time+suffix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            colse(bos,bis);
        }
    }




    /**
     * 上传菜谱封面
     * @param multipartFile
     */
    @Deprecated
    public static int uploadMenuCover(int lastPkId,MultipartFile multipartFile){
        lastPkId++;
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));//后缀
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        InputStream is = null;
        String filePath;
        try {
            is = multipartFile.getInputStream();
            bis = new BufferedInputStream(is);
            filePath = BASE_URL_FILE_MENUS+ "menu"+lastPkId;//用户菜谱文件夹

            File file = new File(filePath);
            if (!file.exists()){
                file.mkdirs();
            }
            File outputFile = new File(filePath+File.separator+0+suffix);
            FileOutputStream fos = new FileOutputStream(outputFile);
            bos = new BufferedOutputStream(fos);

            byte buff[] = new byte[1024];
            int len;
            while ((len = bis.read(buff))!=-1){
                bos.write(buff,0,len);
            }
            bos.flush();
            return lastPkId;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }finally {
            colse(bos,bis);
        }
    }


    /**
     * 上传菜谱步骤图片
     * @param files
     * @return
     */
    public static List<Map<String,Object>> uploadMenuStepPicture(List<MultipartFile> files){
        //List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("stepPicture");
        MultipartFile file = null;
        BufferedOutputStream bos = null;
        List<Map<String,Object>> urls =new ArrayList<>();

        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));//后缀
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    long time = System.currentTimeMillis();
                    String name = time+suffix;
                    bos = new BufferedOutputStream(new FileOutputStream(new File(BASE_URL_FILE_MENUS+File.separator+name)));
                    bos.write(bytes);
                    bos.close();
                    Map<String,Object> map = new HashMap<>();
                    map.put("url",name);
                    urls.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(bos!=null){
                        try {
                            bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return urls;
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
