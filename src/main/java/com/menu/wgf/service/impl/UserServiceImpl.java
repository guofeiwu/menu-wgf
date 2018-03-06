package com.menu.wgf.service.impl;

import com.menu.wgf.Constants;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.UserInfoDataObject;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.mapper.UserSignMapper;
import com.menu.wgf.model.*;
import com.menu.wgf.service.UserService;
import com.menu.wgf.ErrorCode;
import com.menu.wgf.util.DateUtils;
import com.menu.wgf.util.ErrorMessageUtils;
import com.menu.wgf.util.IOUtils;
import com.mysql.jdbc.StringUtils;
import com.sun.corba.se.impl.protocol.InfoOnlyServantCacheLocalCRDImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author guofei_wu
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserSignMapper userSignMapper;

    @Override
    public ResultMsg login(Map param) {
        String phone = (String) param.get("phone");
        String password = (String) param.get("password");
        UserCriteria example = new UserCriteria();
        example.createCriteria()
                .andTUserPhoneEqualTo(phone)
                .andTUserPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        if(users.size()>0) {
            user = users.get(0);
        }else{
            return ResultMsg.failed().addContent("content", ErrorMessageUtils.errorMessage(ErrorCode.USER_LOGIN_FAILED));
        }
        int loginKey = user.gettUserPkid();

        Map map = new HashMap();
        map.put(Constants.LOGIN_LOGIN_KEY,phone);
        map.put(Constants.LOGIN_PKID_KEY,loginKey);
        Map.Entry<String, String> jwtHeader = jwtUtil.createJWTHeader(map);//创建token

        return ResultMsg.success().addContent(jwtHeader.getKey(),jwtHeader.getValue());
    }

    @Override
    public ResultMsg smsLogin(String phone) {
        User user = null;
        UserCriteria example = new UserCriteria();
        example.createCriteria()
                .andTUserPhoneIsNotNull()
                .andTUserPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()>0){//用户存在
            user = users.get(0);
        }else{
            return ResultMsg.failed().addContent("content", ErrorMessageUtils.errorMessage(ErrorCode.USER_NOT_EXIST));
        }
        int loginKey = user.gettUserPkid();

        Map map = new HashMap();
        map.put(Constants.LOGIN_LOGIN_KEY,phone);
        map.put(Constants.LOGIN_PKID_KEY,loginKey);
        Map.Entry<String, String> jwtHeader = jwtUtil.createJWTHeader(map);//创建token

        return ResultMsg.success().addContent("content",jwtHeader);
    }

    @Override
    public ResultMsg register(Map param) {
        String phone = (String) param.get("phone");
        String password = (String) param.get("password");
        UserCriteria example = new UserCriteria();
        example.createCriteria()
                .andTUserPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()>0) {
            return ResultMsg.failed().addContent("content",ErrorMessageUtils.errorMessage(ErrorCode.USER_ALREADY_EXIST));
        }

        User user = new User();
        //拼接
        user.settUserName("用户"+password.substring(0,2)+phone.substring(7));
        user.settUserPhone(phone);
        user.settUserPassword(password);
        Date date = new Date();
        user.settUserCdt(date);
        user.settUserUdt(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(date);
        user.settUserBirthday(birthday);

        int result = userMapper.insertSelective(user);
        if(result == 1){
            return ResultMsg.success().addContent("content",Constants.REGISTER_SUCCESS);
        }
        return ResultMsg.failed();
    }

    @Override
    public ResultMsg modifyPassword(Map param) {
        String phone = (String) param.get("phone");
        String password = (String) param.get("password");

        UserCriteria criteria = new UserCriteria();
        criteria.createCriteria()
                .andTUserPhoneIsNotNull()
                .andTUserPhoneEqualTo(phone);

        List<User> users = userMapper.selectByExample(criteria);
        User user = null;
        if(users.size()>0){
            user = users.get(0);
        }else {
            return ResultMsg.failed().addContent("content",ErrorMessageUtils.errorMessage(ErrorCode.USER_NOT_EXIST));
        }
        user.settUserPassword(password);
        Date date = new Date();
        user.settUserUdt(date);
        int update = userMapper.updateByExampleSelective(user,criteria);
        if(update == 1){
            return ResultMsg.success().addContent("content","修改密码成功");
        }
        return ResultMsg.failed().addContent("content","密码修改失败");
    }

    @Override
    public ResultMsg modifyUserInfo(Integer userPkId,UserInfoDataObject userInfoDataObject) {
        User user = new User();
        user.settUserPkid(userPkId);
        if(userInfoDataObject.name!=null){
            user.settUserName(userInfoDataObject.name);
        }
        if(userInfoDataObject.sex!=null){
            user.settUserSex(userInfoDataObject.sex);
        }
        if(userInfoDataObject.birthday!=null){
            user.settUserBirthday(userInfoDataObject.birthday);
        }
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1){
            return ResultMsg.success().addContent("content","修改成功");
        }
        return ResultMsg.failed().addContent("content","修改失败");
    }

    @Override
    public ResultMsg uploadUserIcon(Integer userPkId, Integer type,MultipartFile icon) {
        User user = userMapper.selectByPrimaryKey(userPkId);
        String iconPath = user.gettUserIcon();
        if(iconPath !=null && !iconPath.equals("")) {
            int indexP = iconPath.lastIndexOf(".");
            int indexR = iconPath.lastIndexOf("r");
            int currentIndex = Integer.parseInt(iconPath.substring(indexR + 1, indexP));//用户当前头像的下标

            Map map = IOUtils.uploadFile(userPkId, type, currentIndex, icon);
            int modifyIndex = (int) map.get("currentIndex");
            if (modifyIndex == 0) {
                return ResultMsg.failed().addContent("content", "修改失败");
            }
            String suffix = (String) map.get("suffix");
            if (modifyIndex != 0) {
                String newIconPath = iconPath.substring(0, indexR + 1) + modifyIndex + suffix;
                user.settUserIcon(newIconPath);
                int result = userMapper.updateByPrimaryKeySelective(user);
                if (result == 1) {
                    return ResultMsg.success().addContent("content", "修改成功");
                }
            }
            return ResultMsg.failed().addContent("content", "修改失败");
        }else{
            // 用户还未上传过头像
            Map map = IOUtils.uploadFile(userPkId, type, 0, icon);
            int modifyIndex = (int) map.get("currentIndex");
            if (modifyIndex == 0) {
                return ResultMsg.failed().addContent("content", "修改失败");
            }
            if (modifyIndex != 0) {
                String newIconPath = (String) map.get("filePath");
                user.settUserIcon(newIconPath);
                int result = userMapper.updateByPrimaryKeySelective(user);
                if (result == 1) {
                    return ResultMsg.success().addContent("content", "修改成功");
                }
            }
            return ResultMsg.failed().addContent("content", "修改失败");
        }
    }

    @Override
    public ResultMsg getUserInfo(Integer userPkId) {
        User user = userMapper.selectByPrimaryKey(userPkId);
        if(user!=null) {
            UserInfoDataObject userInfoDataObject = new UserInfoDataObject();
            userInfoDataObject.userPkId = user.gettUserPkid();
            userInfoDataObject.name = user.gettUserName();
            userInfoDataObject.icon = user.gettUserIcon();
            userInfoDataObject.point = user.gettUserPoint();
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
    public ResultMsg modifyPhone(Map param) {
        Map<String,Object> map = new HashMap<>();
        map.put("sonCode",-1);
        Integer userPkId = jwtUtil.getLoginPkid();
        if(userPkId == null){
            return ResultMsg.failed().addContent("content",map);
        }
        String newPhone = (String) param.get("newPhone");
        //判断该手机号是否存在
        UserCriteria criteria = new UserCriteria();
        criteria.createCriteria()
                .andTUserPhoneIsNotNull()
                .andTUserPhoneEqualTo(newPhone);
        List<User> users = userMapper.selectByExample(criteria);
        if(users.size()>0){
            //手机号已经存在,0表示存在且不是旧号码，-1表示不存在
            map.put("sonCode",0);
            Integer pkId = users.get(0).gettUserPkid();
            if(userPkId.equals(pkId)){
                //表示是当前自己旧手机
                map.put("sonCode",1);
            }
            return ResultMsg.failed().addContent("content",map);
        }
        User user = new User();
        user.settUserPkid(userPkId);
        user.settUserPhone(newPhone);
        Date date = new Date();
        user.settUserUdt(date);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 1){
            map.put("sonCode",2);
            return ResultMsg.success().addContent("content",map);
        }
        map.put("sonCode",-1);
        return ResultMsg.failed().addContent("content",map);
    }

    @Override
    public ResultMsg userSign(Integer flag) {
        Integer userPkId = jwtUtil.getLoginPkid();
        Map map = new HashMap(1);
        UserSignCriteria criteria = new UserSignCriteria();
        criteria.createCriteria()
                .andTSignUserPkidEqualTo(userPkId)
                .andTSignCdtBetween(DateUtils.getStartDate(Calendar.getInstance()).getTime(),DateUtils.getEndDate(Calendar.getInstance()).getTime());
        List<UserSign> userSigns = userSignMapper.selectByExample(criteria);

        //判断是否已经签到
        if(flag == 1){
            if(userSigns!=null && userSigns.size()>0){
                User user = userMapper.selectByPrimaryKey(userPkId);
                map.put("sign",1);
                map.put("point",user.gettUserPoint());
                return ResultMsg.success().addContent("content",map);
            }else{
                //还未进行签到
                map.put("sign",2);
                return ResultMsg.success().addContent("content",map);
            }
        }


        //下面是flag等于2，进行签到
        if(userSigns!=null && userSigns.size()>0){
            map.put("sign",1);
            return ResultMsg.success().addContent("content",map);
        }

        //进行签到
        User user = userMapper.selectByPrimaryKey(userPkId);

        int userPoint = user.gettUserPoint();
        int lastPoint = userPoint+1;

        int level1 = 31, level2 = 101, level3 = 201, level4 = 501, level5 = 1001, level6 = 3001;
        if (lastPoint >= 0 && lastPoint < level1) {
            user.settUserLevel("1级");
        } else if (lastPoint >= level1 && lastPoint < level2) {
            user.settUserLevel("2级");
        } else if (lastPoint > level2 && lastPoint < level3) {
            user.settUserLevel("3级");
        } else if (lastPoint > level3 && lastPoint < level4) {
            user.settUserLevel("4级");
        }else if (lastPoint > level4 && lastPoint < level5) {
            user.settUserLevel("5级");
        }else if (lastPoint > level5 && lastPoint < level6) {
            user.settUserLevel("6级");
        }else{
            user.settUserLevel("7级");
        }

        user.settUserPoint(lastPoint);
        user.settUserPkid(userPkId);
        user.settUserUdt(new Date());
        int result = userMapper.updateByPrimaryKeySelective(user);

        UserSign sign = new UserSign();
        sign.settSignUserPkid(userPkId);
        Date date = new Date();
        sign.settSignCdt(date);
        sign.settSignUdt(date);

        int row = userSignMapper.insertSelective(sign);

        if(result == 1 && row == 1){
            map.put("sign",3);
            return ResultMsg.success().addContent("content",map);
        }
        map.put("sign",4);
        return ResultMsg.failed().addContent("content",map);
    }
}
