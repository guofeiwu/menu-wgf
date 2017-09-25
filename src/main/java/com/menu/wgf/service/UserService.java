package com.menu.wgf.service;

import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author guofei_wu
 * 用户相关接口
 */
public interface UserService {

    /**
     * 用户登录
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    ResultMsg login(String phone,String password);

    /**
     * 退出登录
     * @param userPkId
     * @return
     */
    ResultMsg logout(String userPkId);// TODO: 2017/9/25 这个晚点做

    /**
     * 用户注册
     * @param phone 手机号
     * @param password 密码
     * @return
     */
    ResultMsg register(String phone,String password);


    /**
     * 修改(忘记)密码
     * @param phone
     * @param password
     * @return
     */
    ResultMsg modifyPassword(String phone,String password);



    /**
     * 修改用户信息
     * @param userInfoDataObject
     * @return
     */
    ResultMsg modifyUserInfo(UserInfoDataObject userInfoDataObject);

    /**
     * 下载用户头像
     * @param response
     * @param userPkId
     * @param pictureName
     * @return
     */
    ResultMsg downloadUserIcon(HttpServletResponse response,int userPkId,String pictureName);


    /**
     * 上传用户头像
     * @param userPkId
     * @param icon
     * @return
     */
    ResultMsg uploadUserIcon(Integer userPkId,MultipartFile icon);

    /**
     * 获取用户信息
     * @param userPkId
     * @return
     */
    ResultMsg getUserInfo(Integer userPkId);


    /**
     * 修改手机号码
     * @param phone
     * @param newPhone
     * @return
     */
    ResultMsg modifyPhone(String phone,String newPhone);

}
