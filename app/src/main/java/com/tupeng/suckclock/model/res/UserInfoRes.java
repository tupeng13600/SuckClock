package com.tupeng.suckclock.model.res;


import com.tupeng.suckclock.enums.SexType;

import java.io.Serializable;
import java.util.Date;

public class UserInfoRes implements Serializable {

    private String nick;

    private String phone;

    private String avatar;

    private Date birthday;

    private SexType sex;

    private String address;

    private Byte level;

    private Long empiricalValue;

    private Boolean init;

    private String accessToken;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Long getEmpiricalValue() {
        return empiricalValue;
    }

    public void setEmpiricalValue(Long empiricalValue) {
        this.empiricalValue = empiricalValue;
    }

    public Boolean getInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
