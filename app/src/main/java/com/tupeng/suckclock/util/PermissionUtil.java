package com.tupeng.suckclock.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 22670 on 2017/9/22.
 */

public abstract class PermissionUtil {

    /**
     * 请求授权
     *
     * @param context
     * @param requestCode
     * @param permissions
     */
    public static Boolean grantPermission(Activity context, int requestCode, String... permissions) {
        Boolean isAllow = true;
        if (Build.VERSION.SDK_INT >= 23) {
            for (String permission : permissions) {
                if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(context, permission)) {
                    isAllow = false;
                    break;
                }
            }
            if (!isAllow) {
                ActivityCompat.requestPermissions(context, permissions, requestCode);
            }
        }
        return isAllow;
    }
}
