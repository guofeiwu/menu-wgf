package com.menu.wgf.query;

import com.menu.wgf.model.Material;
import com.menu.wgf.model.Step;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author guofei_wu
 * email guofei_wu@163.com
 * 菜谱接口
 */
@Component
public interface MenuQuery {
    /**
     * 获取菜谱列表
     * @param map 获取菜谱列表所需要的条件
     * @return
     */
    List<Map> getMenuList(Map map);

    /**
     * 获取滚动的banner数据
     * @return
     */
    List<Map> getBanners();

    /**
     * 返回最后一个id
     * @return
     */
    Integer getMenuLast();

    /**
     * 插入菜谱的材料（食材)
     * @param materials
     * @return
     */
    int insertMenuMaterials(List<Material> materials);

    /**
     * 插入菜谱的步骤
     * @param step
     * @return
     */
    int insertMenuSteps(List<Step> step);


    /**
     * 获取单个用户的菜谱
     * @param userPkId
     * @return
     */
    List<Map> getUserMenuList(int userPkId);


    /**
     * 获取用户收藏的菜谱
     * @param userPkId
     * @return
     */
    List<Map> getUserCollectList(int userPkId);


    /**
     * 获取用户评论的菜谱
     * @param userPkId
     * @return
     */
    List<Map> getUserCommentMenuList(int userPkId);

    /**
     * 获取用户的美食足迹
     * @param userPkId
     * @return
     */
    List<Map> getUserMenuRecordList(Integer userPkId);
}
