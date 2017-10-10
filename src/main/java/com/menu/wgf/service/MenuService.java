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


    /**
     * 搜索菜谱
     * @param keyword 关键字
     * @return
     */
    ResultMsg searchMenu(String keyword);


    /**
     * 分享菜谱
     * @param userPkId
     * @param menuPkId
     * @return
     */
    ResultMsg shareMenu(int userPkId,int menuPkId);


    /**
     * 浏览足迹
     * @param userPkId
     * @param menuPkId
     * @return
     */
    ResultMsg recordMenu(int userPkId,int menuPkId);


    /**
     * 获取菜谱的排行
     * @param type 1 表示点赞， 2 表示收藏 3 表示浏览
     * @return
     */
    ResultMsg getMenuRank(int type);

    /**
     * 获取菜谱详情
     * @param menuPkId 菜谱主键
     * @return
     */
    ResultMsg getMenuDetail(int menuPkId);



}
