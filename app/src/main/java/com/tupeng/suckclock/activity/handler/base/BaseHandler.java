package com.tupeng.suckclock.activity.handler.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

/**
 * Created by 22670 on 2017/9/19.
 */

public abstract class BaseHandler extends Handler {

    protected Activity activity;

    public BaseHandler(Activity activity) {
        this.activity = activity;
    }

    @Override
    public abstract void handleMessage(Message message);
}
