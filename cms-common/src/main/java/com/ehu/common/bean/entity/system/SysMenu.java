package com.ehu.common.bean.entity.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

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
@TableName("sys_menu")
@Alias("SysMenu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 菜单父编码
     */
	@TableField("parent_id")
	private Integer parentId;
    /**
     * 名称
     */
	private String name;
    /**
     * 请求地址
     */
	private String url;
    /**
     * 是否是菜单
     */
	@TableField("is_menu")
	private Integer isMenu;
    /**
     * 菜单层级
     */
	private Integer level;
    /**
     * 菜单排序
     */
	private Integer sort;
    /**
     * 是否有效 0 无效 1 有效
     */
	private Integer status;
    /**
     * 图标
     */
	private String icon;
    /**
     * 创建时间
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
     * 更新时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("update_time")
	private Date updateTime;
    /**
     * 更新人
     */
	@TableField("update_by")
	private Integer updateBy;

    /**
     * 下级菜单
     */
	@TableField(exist = false)
	private List<SysMenu> child;

	public List<SysMenu> getChild() {
        return child;
    }

    public void setChild(List<SysMenu> child) {
        this.child = child;
    }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreatedBy() {
		return createBy;
	}

	public void setCreatedBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
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
		return this.id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
