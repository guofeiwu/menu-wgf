package com.menu.wgf.util;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 * 返回不重复的N个随机数
 */
public class RandonUtils {
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    public static void main(String [] agrs){
        int result[] = randomCommon(1,20,5);
        for (Integer integer :result){
            System.out.println("integer:"+integer);
        }
    }

}
