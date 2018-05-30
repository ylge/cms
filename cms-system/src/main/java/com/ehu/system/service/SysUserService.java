package com.ehu.system.service;

import com.ehu.common.base.BaseService;
import com.ehu.common.bean.entity.system.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserService extends BaseService<SysUser,String > {

    SysUser getUserByName(String username);

}
