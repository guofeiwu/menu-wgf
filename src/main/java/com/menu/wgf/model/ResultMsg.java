package com.menu.wgf.model;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author guofei_wu
 * @Date 2017/9/20 15:45
 * 通用的返回结果的类
 */
public class ResultMsg {
    private int code;//100表示失败，200表示成功
    private String msg;

    private Map<String,Object> extend = new HashMap<>();
    public static ResultMsg success(){
        ResultMsg msg = new ResultMsg();
        msg.setCode(200);
        msg.setMsg("成功");
        return msg;
    }

    public static ResultMsg failed(){
        ResultMsg msg = new ResultMsg();
        msg.setCode(100);
        msg.setMsg("失败");
        return msg;
    }

    public ResultMsg addContent(String key ,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public ResultMsg(){}
    public ResultMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
