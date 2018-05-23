package com.ehu.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.ehu.common.bean.entity.system.SysUserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    List<SysUserRole> getByUserId(Integer userId);
}
