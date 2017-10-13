package com.menu.wgf.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 菜谱接口
 */
@Component
public interface MenuQuery {
    List<Map> getMenuList(Map map);
    //获取滚动的banner数据
    List<Map> getBanners();
}
