package com.ehu.common.bean;

import java.io.Serializable;

/**
 * Created by Mr.geyl on 2018/5/23.
 * Time:9:16
 * ProjectName:ehu-cms
 */
public class Result<T> implements Serializable {
    public static final Integer OK = 200;
    public static final Integer ERROR = 100;
    /**
     * 状态码，默认是成功
     */
    private int code = OK;

    /**
     * 信息
     */
    private String msg = "操作成功";

    /**
     * 返回结果实体
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
