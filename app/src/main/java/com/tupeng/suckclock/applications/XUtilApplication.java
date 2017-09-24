package com.tupeng.suckclock.applications;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.DbManager;
import org.xutils.x;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by 22670 on 2017/9/20.
 */

public class XUtilApplication extends Application {

    private static DbManager dbManager;

    private static final Integer DB_VERSION = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        setDaoConfig();//配置数据库参数 创建数据库
        x.Ext.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }

    //获取数据库操作对象
    public DbManager getDbManager() {
        return dbManager;
    }

    public static void setDaoConfig() {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("clock.db")
                // 不设置dbDir时, 默认存储在app的私有目录.
                //.setDbDir(new File(Constant.PATH_DB))
                //数据库版本可使用app版本号
                .setDbVersion(DB_VERSION)
                //开启事务
                .setAllowTransaction(true)
                .setDbOpenListener((db) -> db.getDatabase().enableWriteAheadLogging())// 开启WAL, 对写入加速提升巨大
                .setDbUpgradeListener((db, oldVersion, newVersion) -> {
                        // 版本升级监听 可添加字段 删除表 删除数据库等
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // db.dropDb();
                });
        dbManager = x.getDb(daoConfig);
    }

}
