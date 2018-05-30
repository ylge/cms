package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysMenu;

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

    Result save(SysMenu menu);
}
