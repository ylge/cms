package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.vo.UserVO;

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

    Result save(UserVO sysUser);
}
