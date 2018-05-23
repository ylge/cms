package com.ehu.system.service;

import com.baomidou.mybatisplus.service.IService;
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
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> listLevelSysMenu(Map<String, Object> param);

    SysMenu selectByPrimaryKey(String id);

    void update(SysMenu menu);

    void deleteByPrimaryKey(String id);
}
