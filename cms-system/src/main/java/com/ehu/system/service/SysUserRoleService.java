package com.ehu.system.service;

import com.ehu.common.base.BaseService;
import com.ehu.common.bean.entity.system.SysUserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserRoleService extends BaseService<SysUserRole,String> {

    List<SysUserRole> selectByUserId(Integer userId);
}
