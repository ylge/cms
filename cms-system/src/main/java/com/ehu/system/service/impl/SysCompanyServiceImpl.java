package com.ehu.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehu.common.bean.entity.system.SysCompany;
import com.ehu.common.dao.system.SysCompanyMapper;
import com.ehu.system.service.SysCompanyService;
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
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements SysCompanyService {

    @Autowired
    private SysCompanyMapper companyMapper;
    @Override
    public PageInfo<SysCompany> getCompanyList(Object o) {
        List<SysCompany> sysCompanies = companyMapper.selectByMap(null);
        // 用PageInfo对结果进行包装
        PageInfo<SysCompany> page = new PageInfo<>(sysCompanies);
        return page;
    }
}
