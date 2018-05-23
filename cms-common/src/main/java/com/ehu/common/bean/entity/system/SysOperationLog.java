package com.ehu.common.bean.entity.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@TableName("sys_operation_log")
public class SysOperationLog extends Model<SysOperationLog> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 操作人ID
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 操作人姓名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 被操作类
     */
	@TableField("class_name")
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
	@TableField("origin_data")
	private String originData;
    /**
     * 新数据
     */
	@TableField("new_data")
	private String newData;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getOriginData() {
		return originData;
	}

	public void setOriginData(String originData) {
		this.originData = originData;
	}

	public String getNewData() {
		return newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

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
