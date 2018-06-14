package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysRole;
import com.ehu.dao.SysRoleMapper;
import com.ehu.exception.MyException;
import com.ehu.service.SysRoleMenuService;
import com.ehu.service.SysRoleService;
import com.ehu.vo.RoleMenuVO;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Override
    public BaseMapper<SysRole, String> getMappser() {
        return sysRoleMapper;
    }


    @Override
    public Result save(RoleMenuVO roleMenuVO){
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleMenuVO.getRoleId()==null?null:Integer.parseInt(roleMenuVO.getRoleId()));
        BeanUtils.copyProperties(roleMenuVO,sysRole);
        if(sysRole.getRoleId()==null){
            this.insertSelective(sysRole);
            roleMenuVO.setRoleId(sysRole.getRoleId().toString());
        }else{
            this.updateByPrimaryKeySelective(sysRole);
        }
        sysRoleMenuService.grant(roleMenuVO);
        return Result.OK();
    }
}
