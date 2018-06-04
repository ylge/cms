package com.ehu.bean.entity.system;

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
public class SysDepartment implements Serializable{

    /**
     * id
     */
	private Integer departmentId;
    /**
     * 公司代码
     */
	private Integer companyId;
	/**
	 * 公司名称
	 */
	private String companyName;
    /**
     * 部门编号
     */
	private String code;
    /**
     * 部门名称
     */
	private String name;
    /**
     * 上级代码
     */
	private String parentCode;
    /**
     * 部门描述
     */
	private String comment;
    /**
     * 是否有效 0 无效 1 有效
     */
	private Integer status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private String updateBy;

	@Override
	public String toString() {
		return "SysDepartment{" +
			", departmentId=" + departmentId +
			", companyId=" + companyId +
			", companyName=" + companyName +
			", code=" + code +
			", name=" + name +
			", parentCode=" + parentCode +
			", comment=" + comment +
			", status=" + status +
			", createTime=" + createTime +
			", createBy=" + createBy +
			", updateTime=" + updateTime +
			", updateBy=" + updateBy +
			"}";
	}
}
