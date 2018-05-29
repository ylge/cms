package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.system.entity.SysMenu;
import com.ehu.system.dao.SysMenuMapper;
import com.ehu.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-04-27
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, String> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> listLevelSysMenu(Map<String, Object> param) {
        return sysMenuMapper.listLevelSysMenu(param);
    }

    @Override
    public BaseMapper<SysMenu, String> getMappser() {
        return sysMenuMapper;
    }
}
