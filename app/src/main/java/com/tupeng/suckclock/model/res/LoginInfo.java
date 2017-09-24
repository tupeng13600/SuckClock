package com.tupeng.suckclock.model.res;

import java.util.Date;

/**
 * Created by 22670 on 2017/9/19.
 */

public class LoginInfo {

    private String token = "TUPENGTESTTOKEN";

    private String phone = "18810427265";

    private String nick = "图图";

    private Date invalidTime;

    private Boolean init = false;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Boolean getInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }
}
