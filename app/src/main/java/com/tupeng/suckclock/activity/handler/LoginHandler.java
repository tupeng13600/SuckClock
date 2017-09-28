package com.tupeng.suckclock.activity.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.tupeng.suckclock.activity.InfoInitActivity;
import com.tupeng.suckclock.activity.MyClockActivity;
import com.tupeng.suckclock.activity.VerifyCodeActivity;
import com.tupeng.suckclock.activity.handler.base.BaseHandler;
import com.tupeng.suckclock.constant.Constant;

/**
 * Created by 22670 on 2017/9/19.
 */

public class LoginHandler extends BaseHandler {

    private static String logTag = Constant.tag(LoginHandler.class);

    public LoginHandler(Activity activity) {
        super(activity);
    }

    @Override
    public void handleMessage(Message message) {
        switch (message.what) {
            case Constant.INIT_SUCCESS:
                toMyClock();
                break;
            case Constant.NOT_INIT:
                toInit();
                break;
            default:
                Toast.makeText(activity, message.obj.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void toInit() {
        Intent intent = new Intent(activity, InfoInitActivity.class);
        activity.startActivity(intent);
    }

    private void toMyClock() {
        Intent intent = new Intent(activity, MyClockActivity.class);
        activity.startActivity(intent);
    }
}
