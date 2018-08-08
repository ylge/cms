package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysDepartmentUser;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.bean.entity.system.SysUserRole;
import com.ehu.dao.SysUserMapper;
import com.ehu.service.SysDepartmentUserService;
import com.ehu.service.SysUserRoleService;
import com.ehu.service.SysUserService;
import com.ehu.shiro.ShiroKit;
import com.ehu.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, String> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysDepartmentUserService departmentUserService;

    @Override
    public BaseMapper<SysUser, String> getMappser() {
        return sysUserMapper;
    }

    @Override
    public SysUser getUserByName(String username) {
        return sysUserMapper.getUserByName(username);
    }

    @Override
    public Result deleteUser(String userId) {
        //删除用户
        super.deleteByPrimaryKey(userId);
        //删除用户部门
        sysUserRoleService.deleteByUserId(userId);
        //删除用户角色
        departmentUserService.deleteByUserId(userId);
        return Result.OK();
    }

    @Override
    public Result saveUser(UserVO userVO) throws Exception {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userVO, sysUser);
        String salt = ShiroKit.getRandomSalt(5);
        sysUser.setSalt(salt);
        String saltPwd = ShiroKit.md5(sysUser.getPassword(), salt);
        sysUser.setPassword(saltPwd);
        if (ObjectUtils.isEmpty(userVO.getUserId())) {
            super.insertSelective(sysUser);
        } else {
            super.updateByPrimaryKeySelective(sysUser);
        }
        //增加角色
        if (!ObjectUtils.isEmpty(userVO.getRoles())) {
            String[] roles = userVO.getRoles().split(",");
            Arrays.stream(roles).forEach(s -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(Integer.valueOf(s));
                sysUserRole.setUserId(sysUser.getUserId());
                sysUserRoleService.insertSelective(sysUserRole);
            });
        }
        //增加部门
        if (!ObjectUtils.isEmpty(userVO.getDepartmentId())) {
            SysDepartmentUser sysDepartmentUser = new SysDepartmentUser();
            sysDepartmentUser.setUserId(sysUser.getUserId());
            sysDepartmentUser.setDepartmentId(Integer.parseInt(userVO.getDepartmentId()));
            departmentUserService.insertSelective(sysDepartmentUser);
        }
        return Result.OK();
    }

}
