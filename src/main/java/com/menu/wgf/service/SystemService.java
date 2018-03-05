package com.menu.wgf.service;

import com.menu.wgf.model.ResultMsg;

import java.util.Map;

/**
 * @author guofei_wu
 * @Date 2017/9/25 17:15
 */
public interface SystemService {
    /**
     * 意见反馈
     * @param map
     * @return
     */
    ResultMsg feedback(Map map);

    /**
     * 更新版本
     * @return
     */
    ResultMsg updateVersion();
}
