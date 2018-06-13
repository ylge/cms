package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysMenu;
import com.ehu.dao.SysMenuMapper;
import com.ehu.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<SysMenu> getMenu(ArrayList<SysMenu> menuLists,Object parentId) {
        List<SysMenu> list = sysMenuMapper.getMenuByParentId(parentId.toString());
        list.forEach(sysMenu -> {
            menuLists.add(sysMenu);
            getMenu(menuLists,sysMenu.getId());
        });
        return menuLists;
    }

    @Override
    public List<SysMenu> listLevelSysMenu(Map<String, Object> param) {
        return sysMenuMapper.listLevelSysMenu(param);
    }

    @Override
    public Result save(SysMenu menu) {
        if(menu.getStatus()==null){
            menu.setStatus(1);
        }
        if (menu.getSort() == null){
            menu.setSort(1);
        }
        if(menu.getId()!=null){
            this.updateByPrimaryKeySelective(menu);
        }else {
            this.insertSelective(menu);
        }
        return Result.OK();
    }

    @Override
    public List<SysMenu> getAllMenu() {
        return sysMenuMapper.getAllMenu();
    }

    @Override
    public BaseMapper<SysMenu, String> getMappser() {
        return sysMenuMapper;
    }
}
