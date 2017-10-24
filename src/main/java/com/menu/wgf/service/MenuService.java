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

}
