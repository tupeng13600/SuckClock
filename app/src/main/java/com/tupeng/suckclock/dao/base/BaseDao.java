package com.tupeng.suckclock.dao.base;

import android.util.Log;

import com.tupeng.suckclock.constant.Constant;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 22670 on 2017/9/20.
 */

public class BaseDao<T> {

    private static String logTag = Constant.tag(BaseDao.class);

    protected DbManager dbManager;

    public BaseDao(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * 新增
     *
     * @param entity
     */
    public void insert(T entity) {
        try {
            dbManager.save(entity);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 批量新增
     *
     * @param entities
     */
    public void insertBatch(List<T> entities) {
        try {
            dbManager.save(entities);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 根据ID删除
     *
     * @param entity
     */
    public void delete(T entity) {
        try {
            dbManager.delete(entity);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 删除表
     */
    public void deleteAll(Class<T> clazz) {
        try {
            dbManager.dropTable(clazz);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 根据ID批量删除
     *
     * @param entities
     */
    public void deleteBatch(List<T> entities) {
        try {
            dbManager.delete(entities);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 根据ID更新数据
     *
     * @param entity
     */
    public void update(T entity) {
        try {
            dbManager.update(entity);
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
    }

    /**
     * 获取所有数据
     *
     * @param clazz
     * @return
     */
    public List<T> getAll(Class<T> clazz) {
        List<T> entities = new ArrayList<>();
        try {
            entities = dbManager.selector(clazz).findAll();
            if (null == entities) {
                return new ArrayList<>();
            }
        } catch (DbException e) {
            Log.e(logTag, "数据库操作异常");
            e.printStackTrace();
        }
        return entities;
    }


}
