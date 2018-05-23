package com.ehu.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehu.common.bean.entity.system.SysMenu;
import com.ehu.common.dao.system.SysMenuMapper;
import com.ehu.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> listLevelSysMenu(Map<String, Object> param) {
        return sysMenuMapper.listLevelSysMenu(param);
    }

    @Override
    public SysMenu selectByPrimaryKey(String id) {
        return sysMenuMapper.selectById(Integer.valueOf(id));
    }

    @Override
    public void update(SysMenu menu) {
        sysMenuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void deleteByPrimaryKey(String id) {
        sysMenuMapper.deleteById(Integer.valueOf(id));
    }
}
