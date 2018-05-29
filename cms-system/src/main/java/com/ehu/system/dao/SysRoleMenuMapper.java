package com.ehu.system.dao;

import com.ehu.common.base.BaseMapper;
import com.ehu.system.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu,String> {

    List<SysRoleMenu> selectByRoleId(Integer roleId);
}