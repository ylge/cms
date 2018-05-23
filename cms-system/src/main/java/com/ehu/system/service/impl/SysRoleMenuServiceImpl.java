package com.ehu.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehu.common.bean.entity.system.SysRoleMenu;
import com.ehu.common.dao.system.SysRoleMenuMapper;
import com.ehu.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    public List<SysRoleMenu> getByRoleId(Integer roleId) {
        return this.selectList(new Wrapper<SysRoleMenu>() {
            @Override
            public String getSqlSegment() {
                return "where role_id = "+roleId;
            }
        });
    }
}
