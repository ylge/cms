package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.entity.system.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysRoleService extends BaseService<SysRole,String> {

    List<SysRole> selectAllRole();
}
