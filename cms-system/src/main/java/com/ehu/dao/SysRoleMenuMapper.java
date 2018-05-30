package com.ehu.dao;

import com.ehu.base.BaseMapper;
import com.ehu.bean.entity.system.SysRoleMenu;

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