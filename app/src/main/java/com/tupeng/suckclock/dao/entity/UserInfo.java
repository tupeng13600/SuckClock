package com.tupeng.suckclock.dao.entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.Date;

/**
 * Created by 22670 on 2017/9/20.
 */
@Table(name = "user_info")
public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String token, String phone, String nick, Date invalidTime, Boolean init) {
        this.token = token;
        this.phone = phone;
        this.nick = nick;
        this.invalidTime = invalidTime;
        this.init = init;
    }

    @Column(name = "id", isId = true)
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "phone")
    private String phone;

    @Column(name = "nick")
    private String nick;

    @Column(name = "invalid_time")
    private Date invalidTime;

    @Column(name = "init")
    private Boolean init;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getInit() {
        return init;
    }

    public void setInit(Boolean init) {
        this.init = init;
    }
}
