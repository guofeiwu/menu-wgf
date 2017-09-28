package com.menu.wgf.util;

import com.menu.wgf.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
public class ErrorMessageUtils {
    public static Map errorMessage(ErrorCode errorCode){
        int code = errorCode.getCode();
        String message = errorCode.getMessage();
        Map map = new HashMap();
        map.put("code",code);
        map.put("message",message);
        return map;
    }
}
