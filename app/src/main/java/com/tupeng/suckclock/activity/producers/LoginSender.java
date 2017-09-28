package com.tupeng.suckclock.activity.producers;

import android.os.Message;

import com.tupeng.suckclock.activity.LoginActivity;
import com.tupeng.suckclock.activity.producers.base.MessageSender;
import com.tupeng.suckclock.constant.Constant;
import com.tupeng.suckclock.constant.ServerConstant;
import com.tupeng.suckclock.dao.UserInfoDao;
import com.tupeng.suckclock.dao.entity.UserInfo;
import com.tupeng.suckclock.model.req.LoginRequest;
import com.tupeng.suckclock.model.res.UserInfoRes;
import com.tupeng.suckclock.model.res.base.Response;
import com.tupeng.suckclock.util.HttpUtil;

import java.util.Date;

/**
 * Created by 22670 on 2017/9/19.
 */

public class LoginSender extends MessageSender<LoginActivity> {

    public LoginSender(LoginActivity activity) {
        super(activity);
    }

    @Override
    public void buildMessage(Message message) {
        LoginRequest request = new LoginRequest(activity.phone, activity.verifyCode);
        Response<UserInfoRes> info = HttpUtil.post(ServerConstant.SERVER_HOST, ServerConstant.LOGIN_PATH, request);
        if(info.getStatus()) {
            message.obj = info;
            message.what = info.getData().getInit() ? Constant.INIT_SUCCESS : Constant.NOT_INIT;
        } else {
            message.obj = info.getErrorMessage();
            message.what = Constant.LOGIN_FAIL;
        }

    }
}
