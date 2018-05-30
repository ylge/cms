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
public class SysRoleMenu implements Serializable{

	private Integer roleId;
	private Integer menuId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	@Override
	public String toString() {
		return "SysRoleMenu{" +
			", roleId=" + roleId +
			", menuId=" + menuId +
			", createTime=" + createTime +
			"}";
	}

}
