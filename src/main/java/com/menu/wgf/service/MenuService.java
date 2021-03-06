package com.menu.wgf.service;

import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.dto.MenuContentDataObject;
import com.menu.wgf.dto.UpMenuDataObject;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author guofei_wu
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
     * @param commentDataObject
     * @return
     */
    ResultMsg commentMenu(CommentDataObject commentDataObject);


    /**
     * 删除菜谱评论
     * @param commentPkId
     * @return
     */
    ResultMsg deleteCommentMenu(int commentPkId);


    /**
     * 获取菜谱评论
     * @param menuPkId
     * @param pageNo
     * @return
     */
    ResultMsg getMenuCommentList(int menuPkId,int pageNo);


    /**
     * 获取用户评论的菜谱列表
     * @param pageNo
     * @return
     */
    ResultMsg getUserCommentMenuList(int pageNo);

    /**
     * 收藏菜谱
     * @param menuPkId
     * @return
     */
    ResultMsg collectMenu(int menuPkId);


    /**
     * 获取用户收藏的菜谱列表
     * @param pageNo
     * @return
     */
    ResultMsg getUserCollectMenuList(int pageNo);

    /**
     * 获取用户发布的菜谱列表
     * @param pageNo
     * @return
     */
    ResultMsg getUserMenuList(int pageNo);
    /**
     * 获取菜谱详情
     * @param menuPkId 菜谱主键
     * @return
     */
    ResultMsg getMenuDetail(int menuPkId);


    /**
     * 点赞菜谱
     * @param menuPkId
     * @return
     */
    ResultMsg likeMenu(int menuPkId);

    /**
     * 取消点赞菜谱
     * @param menuPkId
     * @return
     */
    ResultMsg dislikeMenu(int menuPkId);

    /**
     * 取消收藏
     * @param collectPkId
     * @return
     */
    ResultMsg notCollectMenu(int collectPkId);

    /**
     * 获取首页的banner菜谱
     * @return
     */
    ResultMsg getBannerMenu();


    /**
     *上传菜谱封面和一些其他的信息
     * @param menuName
     * @param menuDesc
     * @param menuType
     * @param menuTypeSun
     * @param cover
     * @return
     */
    @Deprecated
    ResultMsg uploadMenuCover(String menuName,String menuDesc,Integer menuType, Integer menuTypeSun,MultipartFile cover);

    /**
     * 上传菜谱封面
     * @param cover
     * @return
     */
    ResultMsg uploadMenuCover(MultipartFile cover);

    /**
     * 上传菜谱图片
     * @param stepPicture
     * @return
     */
    ResultMsg upStepPicture(List<MultipartFile> stepPicture);

    /**
     * 上传菜谱内容
     * @param menuContentDataObject
     * @return
     */
    ResultMsg upMenuContent(MenuContentDataObject menuContentDataObject);


    /**
     * 判断当前用户在此菜谱中是否还有评论
     * @param menuPkId
     * @return
     */
    ResultMsg judgeHasComment(int menuPkId);


    /**
     * 添加用户足迹
     * @param menuPkId
     * @return
     */
    ResultMsg addUserMenuRecord(int menuPkId);

    /**
     * 获取用户的美食足迹
     * @param pageNo
     * @return
     */
    ResultMsg getUserMenuRecord(int pageNo);

    /**
     * 删除用户美食足迹（单个删除）
     * @param recordPkId
     * @return
     */
    ResultMsg deleteUserRecord(Integer recordPkId);

    /**
     * 删除用户所有美食足迹
     * @return
     */
    ResultMsg deleteUserAllRecord();


    /**
     * 判断用户今日是否已经发布菜谱
     * @return
     */
    ResultMsg judgeTodayAlreadyReleaseMenu();

    /**
     * 获取点赞前10的菜谱
     * @return
     */
    ResultMsg getLikeRankTen();

    /**
     * 获取收藏前10的菜谱
     * @return
     */
    ResultMsg getCollectRankTen();

    /**
     * 获取浏览的菜谱
     * @param pageNo
     * @return
     */
    ResultMsg getLookRank(int pageNo);


    /**
     * 获取专题菜谱列表
     * @param map 封装了参数
     * @return
     */
    ResultMsg getThematicMenuList(Map map);


    /**
     * 获取菜谱专题标题（2个）
     * @param pageNO
     * @return
     */
    ResultMsg getThematicTitle(int pageNO);

    /**
     * 随机返回菜谱列表
     * @return
     */
    ResultMsg getRandomMenuList();

}
