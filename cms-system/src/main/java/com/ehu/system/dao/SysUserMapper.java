package com.ehu.system.dao;

import com.ehu.common.base.BaseMapper;
import com.ehu.system.entity.SysUser;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserMapper extends BaseMapper<SysUser,String> {

    SysUser getUserByName(String username);
}