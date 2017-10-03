package com.menu.wgf.query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 晒一晒查询接口
 */
@Component
public interface ShaiQuery {
    List<Map> getAllShaiList();
}
