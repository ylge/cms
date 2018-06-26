package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysMenu;
import com.ehu.bean.entity.system.SysUserRole;

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

    void deleteByUserId(String userId);
}
