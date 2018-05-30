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
	private Integer createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private Integer updateBy;

	@Override
	public String toString() {
		return "SysDepartment{" +
			", departmentId=" + departmentId +
			", companyId=" + companyId +
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
