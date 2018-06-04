package com.ehu.service.impl;

import com.ehu.base.BaseMapper;
import com.ehu.base.impl.BaseServiceImpl;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysDepartment;
import com.ehu.dao.SysDepartmentMapper;
import com.ehu.service.SysDepartmentService;
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

    @Override
    public Result save(SysDepartment sysDepartment) {
        if(sysDepartment.getDepartmentId()==null){
            this.insertSelective(sysDepartment);
        }else{
            this.updateByPrimaryKey(sysDepartment);
        }
        return Result.OK();
    }
}
