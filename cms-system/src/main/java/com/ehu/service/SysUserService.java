package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.entity.system.SysUser;

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
