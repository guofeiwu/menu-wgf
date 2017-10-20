package com.menu.wgf.service;

import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author guofei_wu
 * @Date 2017/9/25 12:07
 */
public interface ShaiService {

    /**
     * 获取用户的点赞的晒一晒
     * @param userPkId
     * @return
     */
    ResultMsg getLikeShai(int userPkId);

    /**
     * 用户点赞晒一晒
     * @param userPkId
     * @param shaiPkId
     * @return
     */
    ResultMsg likeShai(int userPkId,int shaiPkId);


    /**
     * 用户取消赞 晒晒
     * @param likePkId
     * @return
     */
    ResultMsg disLikeShai(int likePkId);



    /**
     * 评论晒一晒
     * @param userPkId
     * @param commentDataObject
     * @return
     */
    ResultMsg commentShai(int userPkId,CommentDataObject commentDataObject);

    /**
     * 删除晒一晒评论
     * @param commentPkId
     * @return
     */
    ResultMsg deleteCommentShai(int commentPkId);

    /**
     * 获取对应晒一晒的评论
     * @param shaiPkId
     * @return
     */
    ResultMsg getShaiCommentList(int shaiPkId, int pageNo);

    /**
     * 上传晒一晒
     * @param userPkId
     * @param desc 描述
     * @param shaiPicture
     * @return
     */
    ResultMsg uploadShai(Integer userPkId,String desc,
                             MultipartFile shaiPicture);

    /**
     * 删除晒一晒
     * @param shaiPkId
     * @return
     */
    ResultMsg deleteShai(int shaiPkId);


    /**
     * 获取某个用户的晒一晒
     * @param pageNo
     * @return
     */
    ResultMsg getUserShai(int pageNo);

    /**
     * 获取所有的晒一晒，分页
     * @param pageNo 第几页
     * @return
     */
    ResultMsg getShaiList(int pageNo);

    /**
     * 获取单个晒晒的详情
     * @param shaiPkId
     * @return
     */
    ResultMsg getShaiDetail(int shaiPkId);


    /**
     * 更新晒一晒浏览次数
     * @param shaiPkId
     * @return
     */
    ResultMsg updateShaiLook(int lookTotal,int shaiPkId);


    /**
     * 获取某个用户评论的晒一晒
     * @param pageNo
     * @return
     */
    ResultMsg getUserCommentShaiList(int pageNo);
}
