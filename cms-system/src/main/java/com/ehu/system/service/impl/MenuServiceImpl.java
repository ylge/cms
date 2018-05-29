package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.system.entity.SysMenu;
import com.ehu.system.dao.SysMenuMapper;
import com.ehu.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/8/2.
 * Time:14:01
 * ProjectName:Common-admin
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<SysMenu, String> implements MenuService {
    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getMenu() {
        List<SysMenu> list = menuMapper.getMenu();
        return list;
    }


    @Override
    public BaseMapper<SysMenu, String> getMappser() {
        return menuMapper;
    }
}
