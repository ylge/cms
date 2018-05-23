package com.ehu.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehu.common.bean.entity.system.SysUserRole;
import com.ehu.common.dao.system.SysUserRoleMapper;
import com.ehu.system.service.SysUserRoleService;
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
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public List<SysUserRole> getByUserId(Integer userId) {
        return this.selectList(new Wrapper<SysUserRole>() {
            @Override
            public String getSqlSegment() {
                return "where user_id ="+userId;
            }
        });
    }
}
