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
@TableName("sys_company")
public class SysCompany extends Model<SysCompany> {

    private static final long serialVersionUID = 1L;

	@TableId(value="company_id", type= IdType.AUTO)
	private Integer companyId;
    /**
     * 公司代码
     */
	private String code;
    /**
     * 公司名称
     */
	private String name;
    /**
     * 公司简称
     */
	@TableField("short_name")
	private String shortName;
    /**
     * 上级代码
     */
	@TableField("parent_code")
	private String parentCode;
    /**
     * 公司LOGO
     */
	private String logo;
    /**
     * 公司介绍
     */
	private String comment;
    /**
     * 公司地址
     */
	private String address;
    /**
     * 城市代码
     */
	@TableField("city_code")
	private String cityCode;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
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
		return this.companyId;
	}

	@Override
	public String toString() {
		return "SysCompany{" +
			", companyId=" + companyId +
			", code=" + code +
			", name=" + name +
			", shortName=" + shortName +
			", parentCode=" + parentCode +
			", logo=" + logo +
			", comment=" + comment +
			", address=" + address +
			", cityCode=" + cityCode +
			", status=" + status +
			", createTime=" + createTime +
			", createBy=" + createBy +
			", updateTime=" + updateTime +
			", updateBy=" + updateBy +
			"}";
	}
}
