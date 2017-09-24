package com.tupeng.suckclock.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by 22670 on 2017/9/23.
 */

public class FileUtil {

    /**
     * bitmap 转 byte[]
     * @param bitmap
     * @return
     */
    public static byte[] toByte(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return baos.toByteArray();
    }

    /**
     *
     * byte[] 转 bitmap
     *
     * @param bytes
     * @return
     */
    public static Bitmap toBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
