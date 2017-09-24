package com.tupeng.suckclock.activity.handler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.tupeng.suckclock.activity.LoginActivity;
import com.tupeng.suckclock.activity.handler.base.BaseHandler;
import com.tupeng.suckclock.constant.Constant;
import com.tupeng.suckclock.model.res.VersionResponse;

/**
 * Created by 22670 on 2017/9/19.
 */
public class VersionHandler extends BaseHandler {

    private static String logTag = Constant.tag(VersionHandler.class);

    private static final int NEED_UPDATE = 1;

    private static final int NOT_UPDATE = 0;

    public VersionHandler(Activity activity) {
        super(activity);
    }

    @Override
    public void handleMessage(Message message) {
        switch (message.what){
            case NEED_UPDATE:
                builderUpdateDialog(message);
                break;
            case NOT_UPDATE:
                toLogin();
                break;
            default:
                Log.w(logTag, "匹配版本参数错误");
        }
    }

    private void builderUpdateDialog(Message message){
        Bundle bundle = message.getData();
        VersionResponse response = (VersionResponse)bundle.getSerializable("version");
        Log.i(logTag, "获取到新版本信息:" + response.toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("版本更新通知");
        builder.setMessage(response.getRemark());
        builder.setPositiveButton("使用新版本", (DialogInterface dialog, int which) -> Toast.makeText(activity, "正在进行更新", Toast.LENGTH_LONG).show());
        builder.setNegativeButton("使用旧版本", (DialogInterface dialog, int which) -> toLogin());
        builder.show();
    }

    private void toLogin(){
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }
}
