package com.ehu.system.dao;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.bean.entity.system.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysMenuMapper extends BaseMapper<SysMenu,String> {

    List<SysMenu> listLevelSysMenu(Map<String, Object> param);

    List<SysMenu> getMenu();

}