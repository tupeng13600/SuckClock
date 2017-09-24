package com.tupeng.suckclock.activity.producers.base;

import android.app.Activity;
import android.os.Message;

/**
 * Created by 22670 on 2017/9/19.
 */

public abstract class MessageSender<T extends Activity> {

    protected T activity;

    public MessageSender(T activity) {
        this.activity = activity;
    }

    public abstract void buildMessage(Message message);

}
