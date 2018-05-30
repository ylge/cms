package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.common.bean.entity.system.SysUserRole;
import com.ehu.system.dao.SysUserRoleMapper;
import com.ehu.system.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole, String> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public BaseMapper<SysUserRole, String> getMappser() {
        return sysUserRoleMapper;
    }

    @Override
    public List<SysUserRole> selectByUserId(Integer userId) {
        return sysUserRoleMapper.selectByUserId(userId);
    }
}
