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
@TableName("sys_department")
public class SysDepartment extends Model<SysDepartment> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="department_id", type= IdType.AUTO)
	private Integer departmentId;
    /**
     * 公司代码
     */
	@TableField("company_id")
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
	@TableField("parent_code")
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
	@TableField("create_time")
	private Date createTime;
	@TableField("create_by")
	private Integer createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("update_time")
	private Date updateTime;
	@TableField("update_by")
	private Integer updateBy;


	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return this.departmentId;
	}

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
