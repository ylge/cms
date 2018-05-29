package com.ehu.common.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author geyl
 * @Title: ${CLASS_NAME}
 * @Package com.ehu.common.bean
 * @Description: TODO
 * @date 2018-5-23 16:02
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {
    OK(200,"操作成功"),
    FAIL(-1,"操作失败");
    public Integer code;
    public String msg;
}
