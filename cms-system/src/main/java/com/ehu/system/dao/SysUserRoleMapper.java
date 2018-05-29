package com.ehu.system.dao;

import com.ehu.common.base.BaseMapper;
import com.ehu.system.entity.SysUserRole;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole,String> {

    List<SysUserRole> selectByUserId(Integer userId);
}