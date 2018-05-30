package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.entity.system.SysCompany;
import com.ehu.dao.SysCompanyMapper;
import com.ehu.service.SysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  公司服务实现类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
@Service
public class SysCompanyServiceImpl extends BaseServiceImpl<SysCompany, String> implements SysCompanyService {

    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    @Override
    public BaseMapper<SysCompany, String> getMappser() {
        return sysCompanyMapper;
    }

    @Override
    public boolean save(SysCompany sysCompany) {
        return false;
    }
}
