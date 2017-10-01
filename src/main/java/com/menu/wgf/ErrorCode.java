package com.menu.wgf;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 错误代码
 */
public enum  ErrorCode {
    USER_LOGIN_FAILED(1001, "用户名或密码错误"),
    USER_REGISTER_FAILED(1002,"用户注册失败"),
    USER_ALREADY_EXIST(1003,"用户已经存在"),
    USER_NOT_EXIST(1004,"用户不存在"),
    ;

    private final int code;
    private final String message;
    ErrorCode(int code,String meessge){
        this.code = code;
        this.message = meessge;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
