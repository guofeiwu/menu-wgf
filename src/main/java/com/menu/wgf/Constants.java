package com.menu.wgf;

/**
 * @Author guofei_wu
 * @Date 2017/9/25 10:34
 */
public class Constants {

    /**住宿的**/
//    public static final String BASE_URL = "http://192.168.11.103:8081";
//    public static final String BASE_URL_FILE_MENUS = "http://192.168.11.103:8080/menuFiles/menus";//Tomcat服务器菜单文件地址
//    public static final String BASE_URL_FILE_ICON = "D:/Work/tomcat/apache-tomcat-8.5.5-windows-x64/apache-tomcat-8.5.5/webapps/menuFiles/icon/";//Tomcat服务器用户头像地址
    /**公司的**/
//    public static final String BASE_URL = "http://192.168.1.155:8081";
    public static final String BASE_URL_FILE_ICON = "http://192.168.1.155:8080/menuFiles/icon/";//Tomcat服务器用户头像地址
    public static final String BASE_URL_FILE_MENUS = "http://192.168.1.155:8080/menuFiles/menus/";//Tomcat服务器菜单地址
    public static final String BASE_URL_FILE_SHAI = "D:/Work/tomcat/apache-tomcat-8.5.5-windows-x64/apache-tomcat-8.5.5/webapps/menuFiles/shai/";//Tomcat服务器菜单地址



    public static final int FILE_TYPE_SHAI = 0;
    public static final int FILE_TYPE_ICON = 1;
    public static final int FILE_TYPE_MENU = 2;
    public static final String LOGIN_PKID_KEY = "loginPkid";
    public static final String LOGIN_LOGIN_KEY = "login";
    public static final String REGISTER_SUCCESS="注册成功";

    /**
     * 上传的文件类型
     */
    public enum FILE_TYPE{
        FILE_TYPE_SHAI,FILE_TYPE_ICON,FILE_TYPE_MENU;
    }









}
