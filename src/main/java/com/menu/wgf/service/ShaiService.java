package com.menu.wgf.service;

import com.menu.wgf.model.ResultMsg;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author guofei_wu
 * @Date 2017/9/25 12:07
 */
public interface ShaiService {
    /**
     * 评论晒一晒
     * @param userPkId
     * @param shaiPkId
     * @param commentContent
     * @return
     */
    ResultMsg commentShai(int userPkId,int shaiPkId,String commentContent);

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
    ResultMsg getCommentShaiList(int shaiPkId);

    /**
     * 上传晒一晒
     * @param userPkId
     * @param type
     * @param shaiPicture
     * @return
     */
    ResultMsg uploadShaiIcon(Integer userPkId,Integer type,
                             MultipartFile shaiPicture);

    /**
     * 删除晒一晒
     * @param shaiPkId
     * @return
     */
    ResultMsg deleteShai(int shaiPkId);


    /**
     * 获取某个用户的晒一晒
     * @param userPkId
     * @return
     */
    ResultMsg getShai(int userPkId);

    /**
     * 获取所有的晒一晒，分页
     * @return
     */
    ResultMsg getShaiList();
}
