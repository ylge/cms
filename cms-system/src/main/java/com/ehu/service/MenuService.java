package com.ehu.service;


import com.ehu.base.BaseService;
import com.ehu.bean.entity.system.SysMenu;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/8/2.
 * Time:13:59
 * ProjectName:Common-admin
 */
public interface MenuService extends BaseService<SysMenu,String> {

    List<SysMenu> getMenu();
}
