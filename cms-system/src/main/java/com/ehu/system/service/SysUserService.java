package com.ehu.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.ehu.common.bean.entity.system.SysUser;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getUserByName(String username);

    PageInfo<SysUser> getUserList(Object o);
}
