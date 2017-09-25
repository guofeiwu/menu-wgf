package com.menu.wgf.service;

import com.menu.wgf.model.ResultMsg;

/**
 * @Author guofei_wu
 * @Date 2017/9/25 17:15
 */
public interface SystemService {
    /**
     * 意见反馈
     * @param userPkId
     * @param content
     * @return
     */
    ResultMsg feedback(int userPkId,String content);

    /**
     * 关于我们
     * @return
     */
    ResultMsg getAboutUs();

    /**
     * 更新版本
     * @param oldVer
     * @return
     */
    ResultMsg updateVersion(int oldVer);
}
