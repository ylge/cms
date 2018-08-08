package com.ehu.service;

import com.ehu.base.BaseService;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysDepartment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author geyongliang
 * @since 2018-05-11
 */
public interface SysDepartmentService extends BaseService<SysDepartment,String> {

    Result saveDepartment(SysDepartment sysDepartment);
}
