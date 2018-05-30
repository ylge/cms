package com.ehu.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Mr.geyl on 2018/5/23.
 * Time:9:16
 * ProjectName:ehu-cms
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 返回结果实体
     */
    private T data;

    public synchronized static Result OK(){
        return Result.builder().code(ResultCode.OK.code)
                .msg(ResultCode.OK.msg).data(null).build();
    }
    public synchronized static Result OK(Object data){
        return Result.builder().code(ResultCode.OK.code)
                .msg(ResultCode.OK.msg).data(data).build();
    }
    public synchronized static Result Fail(){
        return Result.builder().code(ResultCode.FAIL.code)
                .msg(ResultCode.FAIL.msg).data(null).build();
    }
    public synchronized static Result Fail(Object data){
        return Result.builder().code(ResultCode.FAIL.code)
                .msg(ResultCode.FAIL.msg).data(data).build();
    }

}
