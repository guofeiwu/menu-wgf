package com.menu.wgf.service.impl;

import com.github.pagehelper.PageHelper;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.dto.MenuDataObject;
import com.menu.wgf.mapper.MenuMapper;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.User;
import com.menu.wgf.query.MenuQuery;
import com.menu.wgf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuQuery menuQuery;


    @Override
    public ResultMsg getMenuList(MenuConditionDataObject menuConditionDataObject) {

        int pageNo = menuConditionDataObject.pageNo;
        int type = menuConditionDataObject.type;
        int sunType = menuConditionDataObject.sunType;
        String keyword = menuConditionDataObject.keyword;


        Integer userPkId = jwtUtil.getLoginPkid();

        Map map = new HashMap();
        map.put("pType",String.valueOf(type));
        map.put("sunType",String.valueOf(sunType));
        map.put("keyword",keyword);
        PageHelper.startPage(pageNo,6);
        List<Map> maps = menuQuery.getMenuList(map);
        List<MenuDataObject> menuDataObjects = new ArrayList<>();
        for (Map m:maps){
            MenuDataObject menuDataObject = new MenuDataObject();
            menuDataObject.menuPkId = (int) m.get("menuPkId");
            menuDataObject.menuName = (String) m.get("menuName");
            menuDataObject.introduce = (String) m.get("descr");
            menuDataObject.mainIcon = (String) m.get("mainIcon");
            int userPkId1 = (int) m.get("userPkId");
            User user = userMapper.selectByPrimaryKey(userPkId1);
            menuDataObject.userIconUrl = user.gettUserIcon();
            menuDataObject.userName = user.gettUserName();

            if(userPkId!=null && userPkId == userPkId1){
                menuDataObject.currentUser = 0;//是当前用户，-1表示不是当前用户
            }else{
                menuDataObject.currentUser = -1;
            }
            menuDataObjects.add(menuDataObject);
        }
        return ResultMsg.success().addContent("content",menuDataObjects);
    }

    @Override
    public ResultMsg commentMenu(int userPkId, int menuPkId, String commentContent) {
        return null;
    }

    @Override
    public ResultMsg deleteCommentMenu(int commentPkId) {
        return null;
    }

    @Override
    public ResultMsg getCommentMenuList(int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg getUserCommentMenuList(int userPkId, int pageSize, int pageNo) {
        return null;
    }

    @Override
    public ResultMsg collectMenu(int userPkId, int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg deleteCollectMenu(int collectPkId) {
        return null;
    }

    @Override
    public ResultMsg getUserCollectMenuList(int userPkId, int pageSize, int pageNo) {
        return null;
    }

    @Override
    public ResultMsg searchMenu(String keyword) {
        return null;
    }

    @Override
    public ResultMsg shareMenu(int userPkId, int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg recordMenu(int userPkId, int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg getMenuRank(int type) {
        return null;
    }
}
