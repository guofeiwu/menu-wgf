package com.menu.wgf.service.impl;

import com.github.pagehelper.PageHelper;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.dto.MenuDataObject;
import com.menu.wgf.dto.StepDataObject;
import com.menu.wgf.mapper.MaterialMapper;
import com.menu.wgf.mapper.MenuMapper;
import com.menu.wgf.mapper.StepMapper;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.model.*;
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

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private MaterialMapper materialMapper;




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

    @Override
    public ResultMsg getMenuDetail(int menuPkId) {

        try {
            MenuDataObject menuDataObject = new MenuDataObject();

            Menu menu = menuMapper.selectByPrimaryKey(menuPkId);
            menuDataObject.menuPkId = menu.gettMenuPkid();
            menuDataObject.menuName = menu.gettMenuName();
            menuDataObject.mainIcon = menu.gettMenuMainIcon();
            menuDataObject.introduce = menu.gettMenuDescription();
            int userPkId = menu.gettMenuUserPkid();
            User user = userMapper.selectByPrimaryKey(userPkId);
            menuDataObject.userIconUrl = user.gettUserIcon();
            menuDataObject.userName = user.gettUserName();

            Integer currentUserPkId = jwtUtil.getLoginPkid();
            if(currentUserPkId!=null && userPkId == currentUserPkId){
                menuDataObject.currentUser = 0;
            }else{
                menuDataObject.currentUser = -1;//not current user
            }

            // step
            StepCriteria criteria = new StepCriteria();
            criteria.createCriteria()
                    .andTStepDeleteEqualTo(0)
                    .andTStepMenuPkidEqualTo(menuPkId);
            List<Step> steps = stepMapper.selectByExample(criteria);
            List<StepDataObject> stepList= new ArrayList<>();
            for (Step step:steps){
                StepDataObject stepDataObject = new StepDataObject();
                stepDataObject.stepDesc = step.gettStepDescription();
                stepDataObject.stepIcon = step.gettStepPicAddress();
                stepList.add(stepDataObject);
            }
            menuDataObject.steps = stepList;

            //materials
            MaterialCriteria criteria1 = new MaterialCriteria();
            criteria1.createCriteria()
                    .andTMaterialDeleteEqualTo(0)
                    .andTMaterialMenuPkidEqualTo(menuPkId);

            List<Material> materials = materialMapper.selectByExample(criteria1);
            List<Map<String,Object>> maps = new ArrayList<>();
            for (Material material : materials){
                Map map = new HashMap();
                map.put("materialName",material.gettMaterialName());
                maps.add(map);
            }
            menuDataObject.materials = maps;

            return ResultMsg.success().addContent("content",menuDataObject);

        } catch (Exception e){
            e.printStackTrace();
            return ResultMsg.failed().addContent("content","出现异常！！！");
        }
    }
}
