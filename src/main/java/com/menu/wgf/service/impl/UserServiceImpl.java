package com.menu.wgf.service.impl;

import com.menu.wgf.Constants;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.User;
import com.menu.wgf.model.UserCriteria;
import com.menu.wgf.service.UserService;
import com.menu.wgf.ErrorCode;
import com.menu.wgf.util.ErrorMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public ResultMsg login(String phone, String password) {
        UserCriteria example = new UserCriteria();
        example.createCriteria()
                .andTUserPhoneEqualTo(phone)
                .andTUserPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        if(users.size()>0) {
            user = users.get(0);
        }else{
            return ResultMsg.failed().addContent("failed", ErrorMessageUtils.errorMessage(ErrorCode.USER_LOGIN_FAILED));
        }
        int loginKey = user.gettUserPkid();

        Map map = new HashMap();
        map.put(Constants.LOGIN_LOGIN_KEY,phone);
        map.put(Constants.LOGIN_PKID_KEY,loginKey);
        Map.Entry<String, String> jwtHeader = jwtUtil.createJWTHeader(map);//创建token

        return ResultMsg.success().addContent(jwtHeader.getKey(),jwtHeader.getValue());
    }


    // TODO: 2017/9/27 暂时不写
    @Override
    public ResultMsg logout(String userPkId) {
        return null;
    }

    @Override
    public ResultMsg register(String phone, String password) {
        UserCriteria example = new UserCriteria();
        example.createCriteria()
                .andTUserPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()>0) {
            return ResultMsg.failed().addContent("content",ErrorMessageUtils.errorMessage(ErrorCode.USER_ALREADY_EXIST));
        }

        User user = new User();
        user.settUserName("用户"+password.substring(0,2)+phone.substring(7));//拼接
        user.settUserPhone(phone);
        user.settUserPassword(password);
        Date date = new Date();
        user.settUserCdt(date);
        user.settUserUdt(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(date);
        user.settUserBirthday(birthday);

        int result = userMapper.insertSelective(user);
        if(result == 1)
        return ResultMsg.success().addContent("content",Constants.REGISTER_SUCCESS);
        return ResultMsg.failed();
    }

    @Override
    public ResultMsg modifyPassword(String phone, String password) {
        return null;
    }

    @Override
    public ResultMsg modifyUserInfo(UserInfoDataObject userInfoDataObject) {
        return null;
    }

    @Override
    public ResultMsg downloadUserIcon(HttpServletResponse response, int userPkId, String pictureName) {
        return null;
    }

    @Override
    public ResultMsg uploadUserIcon(Integer userPkId, MultipartFile icon) {
        return null;
    }

    @Override
    public ResultMsg getUserInfo(Integer userPkId) {
        User user = userMapper.selectByPrimaryKey(userPkId);
        if(user!=null) {
            UserInfoDataObject userInfoDataObject = new UserInfoDataObject();
            userInfoDataObject.userPkId = user.gettUserPkid();
            userInfoDataObject.name = user.gettUserName();
            userInfoDataObject.icon = user.gettUserIcon();
            userInfoDataObject.level = user.gettUserLevel();
            userInfoDataObject.birthday = user.gettUserBirthday();
            userInfoDataObject.phone = user.gettUserPhone();
            userInfoDataObject.sign = user.gettUserSign();
            userInfoDataObject.sex = user.gettUserSign();
            return ResultMsg.success().addContent("content", userInfoDataObject);
        }
        return ResultMsg.failed();
    }

    @Override
    public ResultMsg modifyPhone(String phone, String newPhone) {
        return null;
    }
}
