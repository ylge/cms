package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysMenu;
import com.ehu.bean.entity.system.SysRoleMenu;
import com.ehu.dao.SysRoleMenuMapper;
import com.ehu.service.SysMenuService;
import com.ehu.service.SysRoleMenuService;
import com.ehu.util.MenuTreeUtil;
import com.ehu.vo.RoleMenuVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public BaseMapper<SysRoleMenu, String> getMappser() {
        return sysRoleMenuMapper;
    }

    @Override
    public List<SysRoleMenu> selectByRoleId(Integer roleId) {
        return sysRoleMenuMapper.selectByRoleId(roleId);
    }

    @Override
    public Result getMenuByRoleId(String roleId) {
        List<SysMenu> menuLists = sysMenuService.getAllMenu();
        List<SysRoleMenu> roleMenuLists = roleId==null?new ArrayList<>():sysRoleMenuMapper.selectByRoleId(Integer.valueOf(roleId));
        MenuTreeUtil menuTreeUtil = new MenuTreeUtil(menuLists, roleMenuLists);
        List<Map<String, Object>> mapList = menuTreeUtil.buildTree();
        return Result.OK(mapList);
    }

    @Override
    public Result grant(RoleMenuVO roleMenuVO) {
        this.deleteByPrimaryKey(roleMenuVO.getRoleId());
        if (roleMenuVO.getMenuIds() != null && StringUtils.isNotEmpty(roleMenuVO.getRoleId())) {
            if (roleMenuVO.getMenuIds().length>0) {
                Arrays.stream(roleMenuVO.getMenuIds()).forEach(menuId -> {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(Integer.parseInt(roleMenuVO.getRoleId()));
                    sysRoleMenu.setMenuId(Integer.parseInt(menuId));
                    this.insertSelective(sysRoleMenu);
                });
            }
        }
        return Result.OK();
    }
}
