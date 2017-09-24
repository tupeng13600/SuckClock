package com.tupeng.suckclock.activity.producers;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;

import com.tupeng.suckclock.activity.producers.base.MessageSender;
import com.tupeng.suckclock.model.res.VersionResponse;
import com.tupeng.suckclock.util.HttpUtil;

import java.util.Date;

/**
 * Created by 22670 on 2017/9/19.
 */

public class VersionSender extends MessageSender {

    public VersionSender(Activity activity) {
        super(activity);
    }

    @Override
    public void buildMessage(Message message) {
        VersionResponse response = new VersionResponse();
        response.setVersionCode(3);
        response.setVersionName("3.0.1");
        response.setRemark("这是第三个版本了，大家一定要捧场啊");
        response.setUpdateTime(new Date());
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            if(response.getVersionCode() > packageInfo.versionCode) {
                message.what = 1;
                Bundle bundle = new Bundle();
                bundle.putSerializable("version", response);
                message.setData(bundle);
            } else {
                message.what = 0;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
