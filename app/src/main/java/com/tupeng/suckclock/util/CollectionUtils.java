package com.tupeng.suckclock.util;

import java.util.Collection;

/**
 * Created by 22670 on 2017/9/21.
 */

public class CollectionUtils {

    public static Boolean isEmpty(Collection collection) {
        return null == collection || collection.size() == 0;
    }

    public static Boolean isNotEmpty(Collection collection) {
        return null != collection && collection.size() > 0;
    }

}
