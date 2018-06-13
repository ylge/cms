package com.ehu.bean.entity.system;

import com.ehu.bean.PageBean;
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
public class SysRole extends PageBean implements Serializable{


	private Integer roleId;
    /**
     * 角色名称
     */
	private String name;
	private String value;
	private String remark;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private Date updateTime;
    /**
     * 是否有效 0 无效 1 有效
     */
	private Integer status;
	@Override
	public String toString() {
		return "SysRole{" +
			", roleId=" + roleId +
			", name=" + name +
			", value=" + value +
			", remark=" + remark +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", status=" + status +
			"}";
	}
}
