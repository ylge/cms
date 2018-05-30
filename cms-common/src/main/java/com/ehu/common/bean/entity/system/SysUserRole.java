package com.ehu.common.bean.entity.system;

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
public class SysUserRole implements Serializable {

	private Integer id;
	private Integer userId;
	private Integer roleId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String createBy;

	@Override
	public String toString() {
		return "SysUserRole{" +
			", id=" + id +
			", userId=" + userId +
			", roleId=" + roleId +
			", createTime=" + createTime +
			", createBy=" + createBy +
			"}";
	}
}
