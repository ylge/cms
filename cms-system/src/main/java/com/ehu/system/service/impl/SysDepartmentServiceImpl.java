package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.common.bean.entity.system.SysDepartment;
import com.ehu.system.dao.SysDepartmentMapper;
import com.ehu.system.service.SysDepartmentService;
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
public class SysDepartmentServiceImpl extends BaseServiceImpl<SysDepartment,String > implements SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Override
    public BaseMapper<SysDepartment, String> getMappser() {
        return sysDepartmentMapper;
    }
}
