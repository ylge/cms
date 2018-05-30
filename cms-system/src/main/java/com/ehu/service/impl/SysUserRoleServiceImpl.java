package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.entity.system.SysUserRole;
import com.ehu.dao.SysUserRoleMapper;
import com.ehu.service.SysUserRoleService;
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
