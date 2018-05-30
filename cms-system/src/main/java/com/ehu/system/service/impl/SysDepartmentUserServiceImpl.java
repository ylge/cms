package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.common.bean.entity.system.SysDepartmentUser;
import com.ehu.system.dao.SysDepartmentUserMapper;
import com.ehu.system.service.SysDepartmentUserService;
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
