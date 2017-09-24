package com.tupeng.suckclock.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tupeng.suckclock.activity.producers.base.MessageFactory;
import com.tupeng.suckclock.activity.producers.base.MessageSender;
import com.tupeng.suckclock.applications.XUtilApplication;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by 22670 on 2017/9/19.
 */

public class BaseActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    protected void sendMessage(MessageSender sender, Handler handler) {
        this.handler = handler;
        MessageFactory.sendMessage(sender, this.handler);
    }

    public DbManager getDbManager() {
        return ((XUtilApplication) super.getApplication()).getDbManager();
    }


}
