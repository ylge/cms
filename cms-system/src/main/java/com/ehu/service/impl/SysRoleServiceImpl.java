package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysRole;
import com.ehu.dao.SysRoleMapper;
import com.ehu.exception.MyException;
import com.ehu.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, String> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public BaseMapper<SysRole, String> getMappser() {
        return sysRoleMapper;
    }

    @Override
    public List<SysRole> selectAllRole() {
        return sysRoleMapper.selectAllRole();
    }

    @Override
    public Result save(SysRole sysrole){
        if(sysrole.getRoleId()==null){
            this.insertSelective(sysrole);
        }else{
            this.updateByPrimaryKey(sysrole);
        }
        return Result.OK();
    }
}
