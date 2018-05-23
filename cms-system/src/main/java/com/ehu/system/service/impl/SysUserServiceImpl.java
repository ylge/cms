package com.ehu.system.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehu.common.bean.entity.system.SysUser;
import com.ehu.common.dao.system.SysUserMapper;
import com.ehu.system.service.SysUserService;
import com.github.pagehelper.PageInfo;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByName(String username) {
        return this.selectOne(new Wrapper<SysUser>() {
            @Override
            public String getSqlSegment() {
                return "where username ='"+username+"'";
            }
        });
    }

    @Override
    public PageInfo<SysUser> getUserList(Object o) {
        List<SysUser> users = sysUserMapper.selectByMap(null);
        // 用PageInfo对结果进行包装
        PageInfo<SysUser> page = new PageInfo<>(users);
        return page;
    }

}
