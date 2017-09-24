package com.tupeng.suckclock.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tupeng.suckclock.R;
import com.tupeng.suckclock.activity.handler.VersionHandler;
import com.tupeng.suckclock.activity.producers.VersionSender;
import com.tupeng.suckclock.constant.Constant;

public class SplashActivity extends BaseActivity {

    private static String logTag = Constant.tag(SplashActivity.class);

    String versionName = "1.0.0";

    Integer versionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initVersionMessage();
        checkUpdate();
    }

    private void checkUpdate() {
        super.sendMessage(new VersionSender(this), new VersionHandler(this));
    }

    private void initVersionMessage() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionCode = packageInfo.versionCode;
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(logTag, "获取包信息失败");
        }
        TextView versionView = (TextView) findViewById(R.id.tv_version);
        String prefix = versionView.getText().toString();
        versionView.setText(prefix + versionName + ",版本号：" + versionCode);
    }

}
