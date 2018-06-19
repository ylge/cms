package com.ehu.bean.entity.system;

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
public class SysOperationLog implements Serializable {

	private Long id;
    /**
     * 操作人ID
     */
	private Integer userId;
    /**
     * 操作人姓名
     */
	private String userName;
    /**
     * 被操作类
     */
	private String className;
    /**
     * 方法
     */
	private String method;
    /**
     * 参数
     */
	private String args;
    /**
     * 原始数据
     */
	private String originData;
    /**
     * 新数据
     */
	private String newData;

	private Date createTime;

}
