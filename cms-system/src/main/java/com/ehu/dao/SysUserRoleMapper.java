package com.ehu.dao;

import com.ehu.base.BaseMapper;
import com.ehu.bean.entity.system.SysUserRole;

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

    void deleteByUserId(String userId);
}