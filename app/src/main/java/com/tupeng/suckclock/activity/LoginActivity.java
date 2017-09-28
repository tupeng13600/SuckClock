package com.tupeng.suckclock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.tupeng.suckclock.R;
import com.tupeng.suckclock.activity.handler.LoginHandler;
import com.tupeng.suckclock.activity.producers.LoginSender;
import com.tupeng.suckclock.constant.Constant;
import com.tupeng.suckclock.dao.UserInfoDao;
import com.tupeng.suckclock.dao.entity.UserInfo;
import com.tupeng.suckclock.util.CollectionUtils;

import java.util.List;

public class LoginActivity extends BaseActivity {

    public String phone;

    public String verifyCode;

    private static String logTag = Constant.tag(LoginActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        validateToken();
    }

    private void validateToken(){
        UserInfoDao userInfoDao = new UserInfoDao(getDbManager());
        List<UserInfo> userInfoList = userInfoDao.getAll(UserInfo.class);
        if(CollectionUtils.isNotEmpty(userInfoList)) {
            UserInfo userInfo = userInfoList.get(0);
            if(userInfo.getInit()) {
                Intent intent = new Intent(this, MyClockActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, InfoInitActivity.class);
                startActivity(intent);
            }
        }
    }

    public void login(View view) {
        phone = ((EditText) findViewById(R.id.et_phone)).getText().toString();
        verifyCode = ((EditText) findViewById(R.id.et_verify)).getText().toString();
        Log.i(logTag, "电话号码:" + phone + "; 验证码:" + verifyCode);
        super.sendMessage(new LoginSender(this), new LoginHandler(this));
    }
}
