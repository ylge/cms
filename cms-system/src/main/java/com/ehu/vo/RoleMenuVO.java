package com.ehu.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author geyl
 * @Title: ${CLASS_NAME}
 * @Package com.ehu.vo
 * @date 2018-6-9 15:34
 */
@Data
public class RoleMenuVO {

    private String roleId;
    /**
     * 角色名称
     */
    private String name;
    private String value;
    private String remark;
    private Date createTime;
    private Date updateTime;
    /**
     * 是否有效 0 无效 1 有效
     */
    private Integer status;
    private String[] menuIds;
}
