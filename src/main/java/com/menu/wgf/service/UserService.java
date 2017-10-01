package com.menu.wgf.service;

import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author guofei_wu
 * 用户相关接口
 */

public interface UserService {

    /**
     * 用户登录
     * @param param
     * @return
     */
    ResultMsg login(Map param);


    /**
     * 短信快捷登录
     * @param phone
     * @return
     */
    ResultMsg smsLogin(String phone);

    /**
     * 退出登录
     * @param userPkId
     * @return
     */
    ResultMsg logout(String userPkId);// TODO: 2017/9/25 这个晚点做

    /**
     * 用户注册
     * @param param
     * @return
     */
    ResultMsg register(Map param);


    /**
     * 修改(忘记)密码
     * @param param
     * @return
     */
    ResultMsg modifyPassword(Map param);


    /**
     * 修改用户信息
     * @param userPkId
     * @param userInfoDataObject
     * @return
     */
    ResultMsg modifyUserInfo(Integer userPkId ,UserInfoDataObject userInfoDataObject);

    /**
     * 下载用户头像
     * @param response
     * @param userPkId
     * @param pictureName
     * @return
     */
    ResultMsg downloadUserIcon(HttpServletResponse response, int userPkId, String pictureName);


    /**
     * 上传用户头像
     * @param userPkId
     * @param icon
     * @return
     */
    ResultMsg uploadUserIcon(Integer userPkId, Integer type,MultipartFile icon);

    /**
     * 获取用户信息
     * @param userPkId
     * @return
     */
    ResultMsg getUserInfo(Integer userPkId);


    /**
     * 修改手机号码
     * @param param
     * @return
     */
    ResultMsg modifyPhone(Map param);


    /**
     * 用户签到
     * @param userPkId
     * @return
     */
    ResultMsg userSign(Integer userPkId);

}
