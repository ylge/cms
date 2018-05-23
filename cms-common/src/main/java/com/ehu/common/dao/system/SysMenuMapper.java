package com.ehu.common.dao.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listLevelSysMenu(Map<String, Object> param);

    List<SysMenu> getMenu();

    void updateByPrimaryKeySelective(SysMenu menu);
}