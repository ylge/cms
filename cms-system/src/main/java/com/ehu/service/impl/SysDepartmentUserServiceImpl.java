package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.entity.system.SysDepartmentUser;
import com.ehu.dao.SysDepartmentUserMapper;
import com.ehu.service.SysDepartmentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Service
public class SysDepartmentUserServiceImpl extends BaseServiceImpl<SysDepartmentUser, String> implements SysDepartmentUserService {

    @Autowired
    private SysDepartmentUserMapper sysDepartmentUserMapper;
    @Override
    public BaseMapper<SysDepartmentUser, String> getMappser() {
        return sysDepartmentUserMapper;
    }
}
