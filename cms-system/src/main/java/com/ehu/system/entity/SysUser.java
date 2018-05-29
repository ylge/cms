package com.ehu.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Data
public class SysUser implements Serializable{

	private Integer userId;
    /**
     * 头像
     */
	private String avatar;
    /**
     * 账号
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 用户姓名
     */
	private String name;
    /**
     * 商家用户id
     */
	private String merchantId;
    /**
     * 盐
     */
	private String salt;
    /**
     * 手机号码
     */
	private String phone;
	/**
     * 是否有效 0 无效 1 有效
     */
	private Integer status;
	/**
	 * 创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
     * 创建人
     */
	private String createBy;
	/**
     * 更新日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
    /**
     * 更新人
     */
	private String updateBy;

	private List<SysRole> roleList;

	@Override
	public String toString() {
		return "SysUser{" +
			", userId=" + userId +
			", avatar=" + avatar +
			", username=" + username +
			", password=" + password +
			", name=" + name +
			", merchantId=" + merchantId +
			", salt=" + salt +
			", phone=" + phone +
			", status=" + status +
			", createTime=" + createTime +
			", createBy=" + createBy +
			", updateTime=" + updateTime +
			", updateBy=" + updateBy +
			"}";
	}

}
