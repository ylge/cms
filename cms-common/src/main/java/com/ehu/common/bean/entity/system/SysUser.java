package com.ehu.common.bean.entity.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

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
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="user_id", type= IdType.AUTO)
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
	@TableField("merchant_id")
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
	@TableField("create_time")
	private Date createTime;
	/**
     * 创建人
     */
	@TableField("create_by")
	private Integer createBy;
	/**
     * 更新日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("update_time")
	private Date updateTime;
    /**
     * 更新人
     */
	@TableField("update_by")
	private Integer updateBy;

	@TableField(exist = false)
	private List<SysRole> roleList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createTime;
	}

	public void setCreatedTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreatedBy() {
		return createBy;
	}

	public void setCreatedBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getUpdatedTime() {
		return updateTime;
	}

	public void setUpdatedTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdatedBy() {
		return updateBy;
	}

	public void setUpdatedBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

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

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
}
