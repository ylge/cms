package com.ehu.system.service;


import com.baomidou.mybatisplus.service.IService;
import com.ehu.common.bean.entity.system.SysCompany;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysCompanyService extends IService<SysCompany> {

    PageInfo<SysCompany> getCompanyList(Object o);
}
