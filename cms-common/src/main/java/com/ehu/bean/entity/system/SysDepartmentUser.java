package com.ehu.bean.entity.system;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Data
public class SysDepartmentUser implements Serializable{

    /**
     * id
     */
	private Integer id;
    /**
     * 部门编码
     */
	private Integer departmentId;
    /**
     * 用户号
     */
	private Integer userId;

	@Override
	public String toString() {
		return "SysDepartmentUser{" +
			", id=" + id +
			", departmentId=" + departmentId +
			", userId=" + userId +
			"}";
	}
}
