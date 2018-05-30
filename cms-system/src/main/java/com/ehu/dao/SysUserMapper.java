package com.ehu.dao;

import com.ehu.base.BaseMapper;
import com.ehu.bean.entity.system.SysUser;

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