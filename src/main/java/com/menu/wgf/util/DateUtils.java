package com.menu.wgf.util;

import java.util.Calendar;
import java.util.Date;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
public class DateUtils {


    /**
     * 获取当天截止时间
     * 获取当天开始时间
     * @return
     */
    public static Calendar getStartDate(Calendar today){
        today.set(Calendar.HOUR_OF_DAY,0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today;
    }

    /**
     * 获取当天截止时间
     * 获取当天结束时间
     * @return
     */
    public static Calendar getEndDate(Calendar endToday){
        endToday.set(Calendar.HOUR_OF_DAY, 23);
        endToday.set(Calendar.MINUTE, 59);
        endToday.set(Calendar.SECOND, 59);
        endToday.set(Calendar.MILLISECOND, 59);
        return endToday;
    }


}
