package com.menu.wgf.service;

import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.model.ResultMsg;

/**
 * @Author guofei_wu
 * 菜谱相关接口
 */
public interface MenuService {
    /**
     * 获取菜谱列表
     * @param menuConditionDataObject
     * @return
     */
    ResultMsg getMenuList(MenuConditionDataObject menuConditionDataObject);

    /**
     * 评论菜谱
     * @param userPkId
     * @param menuPkId
     * @param commentContent
     * @return
     */
    ResultMsg commentMenu(int userPkId,int menuPkId ,String commentContent);


    /**
     * 删除菜谱评论
     * @param commentPkId
     * @return
     */
    ResultMsg deleteCommentMenu(int commentPkId);


    /**
     * 获取菜谱评论
     * @param menuPkId
     * @return
     */
    ResultMsg getCommentMenuList(int menuPkId);


    /**
     * 获取用户评论的菜谱列表
     * @param userPkId
     * @param pageSize
     * @param pageNo
     * @return
     */
    ResultMsg getUserCommentMenuList(int userPkId,int pageSize,int pageNo);

    /**
     * 收藏菜谱
     * @param userPkId
     * @param menuPkId
     * @return
     */
    ResultMsg collectMenu(int userPkId,int menuPkId);

    /**
     * 取消收藏菜谱
     * @param collectPkId
     * @return
     */
    ResultMsg deleteCollectMenu(int collectPkId);


    /**
     * 获取用户收藏的菜谱列表
     * @param userPkId
     * @param pageSize
     * @param pageNo
     * @return
     */
    ResultMsg getUserCollectMenuList(int userPkId,int pageSize,int pageNo);

}
