package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.entity.system.SysOperationLog;
import com.ehu.dao.SysOperationLogMapper;
import com.ehu.service.SysOperationLogService;
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
