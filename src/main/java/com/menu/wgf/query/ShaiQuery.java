package com.menu.wgf.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author guofei_wu
 * email guofei_wu@163.com
 * 晒一晒查询接口
 */
@Component
public interface ShaiQuery {
    /**
     * 获取所有的晒一晒
     * @return
     */
    List<Map> getAllShaiList();

    /**
     * 获取晒一晒的详情
     * @param shaiPkId
     * @return
     */
    Map getShaiDetail(int shaiPkId);

    /**
     * 获取用户发布的晒一晒
     * @param userPkId
     * @return
     */
    List<Map> getUserShaiList(int userPkId);

    /**
     * 获取用户评论的晒一晒的
     * @param userPkId
     * @return
     */
    List<Map> getUserCommentShaiList(int userPkId);
}
