package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.common.bean.entity.system.SysRoleMenu;
import com.ehu.system.dao.SysRoleMenuMapper;
import com.ehu.system.service.SysRoleMenuService;
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
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenu, String> implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public BaseMapper<SysRoleMenu, String> getMappser() {
        return sysRoleMenuMapper;
    }

    @Override
    public List<SysRoleMenu> selectByRoleId(Integer roleId) {
        return sysRoleMenuMapper.selectByRoleId(roleId);
    }
}
