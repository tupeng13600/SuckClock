package com.tupeng.suckclock.util;

/**
 * Created by 22670 on 2017/9/29.
 */

public class StringUtils {

    public static Boolean isEmpty(String des) {
        return null == des || "".equals(des.trim());
    }

    public static Boolean isNotEmpty(String des) {
        return null != des && !"".equals(des.trim());
    }

}
