package com.tupeng.suckclock.model.res.base;

/**
 * Created by 22670 on 2017/9/20.
 */

public class Response<T> {

    private Boolean success = true;

    private String description = "请求成功";

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
