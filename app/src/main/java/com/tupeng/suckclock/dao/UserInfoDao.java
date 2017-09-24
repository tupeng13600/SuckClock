package com.tupeng.suckclock.dao;

import com.tupeng.suckclock.dao.base.BaseDao;
import com.tupeng.suckclock.dao.entity.UserInfo;

import org.xutils.DbManager;

/**
 * Created by 22670 on 2017/9/21.
 */

public class UserInfoDao extends BaseDao<UserInfo> {

    public UserInfoDao(DbManager dbManager) {
        super(dbManager);
    }

}
