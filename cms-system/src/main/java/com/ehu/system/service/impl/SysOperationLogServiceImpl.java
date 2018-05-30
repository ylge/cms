package com.ehu.system.service.impl;

import com.ehu.common.base.BaseMapper;
import com.ehu.common.base.impl.BaseServiceImpl;
import com.ehu.common.bean.entity.system.SysOperationLog;
import com.ehu.system.dao.SysOperationLogMapper;
import com.ehu.system.service.SysOperationLogService;
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
public class SysOperationLogServiceImpl extends BaseServiceImpl<SysOperationLog, String> implements SysOperationLogService {
	@Autowired
    private SysOperationLogMapper sysOperationLogMapper;

    @Override
    public BaseMapper<SysOperationLog, String> getMappser() {
        return sysOperationLogMapper;
    }
}
