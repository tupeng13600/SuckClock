package com.tupeng.suckclock.util;

import android.util.Log;

import com.google.gson.Gson;
import com.tupeng.suckclock.constant.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by 22670 on 2017/9/18.
 */
public abstract class HttpUtil {

    private static String logTag = Constant.tag(HttpUtil.class);

    private static final Integer SUCCESS_CODE = 200;

    /**
     * 暂时使用的假的POST
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T post(Object object, Class<T> res) {
        try {
            return res.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T post(String path, String host, Class<T> responseClass, Object... jsonArgs) {
        if ("".equals(path) || "".equals(host)) {
            return null;
        }
        try {
            URL url = new URL(host + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            initHeader(connection, "POST");
            connection.connect();
            if (null != jsonArgs && jsonArgs.length > 0) {
                initJsonArgs(connection, jsonArgs[0]);
            }
            Integer responseCode = connection.getResponseCode();
            if (SUCCESS_CODE.equals(responseCode)) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String strRead;
                StringBuilder builder = new StringBuilder();
                while ((strRead = reader.readLine()) != null) {
                    builder.append(strRead);
                }
                reader.close();
                Log.i(logTag, "请求得到的数据为：" + builder.toString());
            } else {
                Log.e(logTag, "请求失败，返回代码：" + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T get(String path, String host, Class<T> responseClass) {
        if ("".equals(path) || "".equals(host)) {
            return null;
        }
        try {
            URL url = new URL(host + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            initHeader(connection, "POST");
            connection.connect();
            Integer responseCode = connection.getResponseCode();
            if (SUCCESS_CODE.equals(responseCode)) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String strRead;
                StringBuilder builder = new StringBuilder();
                while ((strRead = reader.readLine()) != null) {
                    builder.append(strRead);
                }
                reader.close();
                Log.i(logTag, "请求得到的数据为：" + builder.toString());
            } else {
                Log.e(logTag, "请求失败，返回代码：" + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T put() {
        return null;
    }

    public static <T> T delete() {
        return null;
    }

    private static void initHeader(HttpURLConnection connection, String method) throws ProtocolException {
        connection.setRequestMethod(method);
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Accept-Language", "zh-cn");
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Content-Length", "23330");
        connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
    }

    private static void initJsonArgs(HttpURLConnection connection, Object param) throws IOException {
        OutputStream out = connection.getOutputStream();
        out.write(new Gson().toJson(param).getBytes());
        out.flush();
        out.close();
    }

}
