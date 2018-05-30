package com.ehu.system.service;

import com.ehu.common.base.BaseService;
import com.ehu.common.bean.entity.system.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-04-27
 */
public interface SysMenuService extends BaseService<SysMenu,String> {

    List<SysMenu> listLevelSysMenu(Map<String, Object> param);

}
