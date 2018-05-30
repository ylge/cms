package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.entity.system.SysRoleMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenu,String> {

    List<SysRoleMenu> selectByRoleId(Integer roleId);
}