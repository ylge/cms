package com.ehu.system.service;


import com.ehu.common.bean.entity.system.SysMenu;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/8/2.
 * Time:13:59
 * ProjectName:Common-admin
 */
public interface MenuService {

    List<SysMenu> getMenu();
}
