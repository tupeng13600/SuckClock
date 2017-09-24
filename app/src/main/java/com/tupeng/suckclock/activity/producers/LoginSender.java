package com.tupeng.suckclock.activity.producers;

import android.os.Message;

import com.tupeng.suckclock.activity.LoginActivity;
import com.tupeng.suckclock.activity.producers.base.MessageSender;
import com.tupeng.suckclock.constant.Constant;
import com.tupeng.suckclock.dao.UserInfoDao;
import com.tupeng.suckclock.dao.entity.UserInfo;
import com.tupeng.suckclock.model.req.LoginRequest;
import com.tupeng.suckclock.model.res.LoginInfo;
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
        LoginInfo info = HttpUtil.post(request, LoginInfo.class);
        info.setInvalidTime(new Date(1536455349000L));  //设置过期时间：
        UserInfoDao userInfoDao = new UserInfoDao(activity.getDbManager());
        userInfoDao.deleteAll(UserInfo.class);
        userInfoDao.insert(new UserInfo(info.getToken(), info.getPhone(), info.getNick(), info.getInvalidTime(), info.getInit()));
        message.obj = info;
        message.what = info.getInit() ? Constant.INIT_SUCCESS : Constant.NOT_INIT;
    }
}
