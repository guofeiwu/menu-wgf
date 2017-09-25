package com.menu.wgf.service;

import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author guofei_wu
 * 用户相关接口
 */
public interface UserService {
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
}
