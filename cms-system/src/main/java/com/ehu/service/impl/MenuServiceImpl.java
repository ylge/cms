package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.entity.system.SysMenu;
import com.ehu.dao.SysMenuMapper;
import com.ehu.service.MenuService;
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
        return menuMapper.getMenu();
    }


    @Override
    public BaseMapper<SysMenu, String> getMappser() {
        return menuMapper;
    }
}
