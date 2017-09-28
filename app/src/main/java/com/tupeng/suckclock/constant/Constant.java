package com.tupeng.suckclock.constant;

/**
 * Created by 22670 on 2017/9/18.
 */

public abstract class Constant {

    public static String tag(Class<?> clazz) {
        return clazz.getSimpleName();
    }

    public static final int INIT_SUCCESS = 1;  //已经进行过信息初始化

    public static final int NOT_INIT = 0;  //未初始化

    public static final int LOGIN_FAIL = -1;

    public static final int IMG_SELECT_CODE = 1;


}
