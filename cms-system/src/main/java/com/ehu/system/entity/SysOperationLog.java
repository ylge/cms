package com.ehu.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Data
public class SysOperationLog implements Serializable {

	private Long id;
    /**
     * 操作人ID
     */
	private Integer userId;
    /**
     * 操作人姓名
     */
	private String userName;
    /**
     * 被操作类
     */
	private String className;
    /**
     * 方法
     */
	private String method;
    /**
     * 参数
     */
	private String args;
    /**
     * 原始数据
     */
	private String originData;
    /**
     * 新数据
     */
	private String newData;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;


	@Override
	public String toString() {
		return "SysOperationLog{" +
			", id=" + id +
			", userId=" + userId +
			", userName=" + userName +
			", className=" + className +
			", method=" + method +
			", args=" + args +
			", originData=" + originData +
			", newData=" + newData +
			", createTime=" + createTime +
			"}";
	}
}
