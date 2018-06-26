package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageResult;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysDepartment;
import com.ehu.service.SysCompanyService;
import com.ehu.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysDepartmentController
 * @Package com.ehu.controller
 * @Description: 部门管理
 * @date 2018-5-18 13:40
 */
@Controller
@RequestMapping(value = "system/department/")
public class SysDepartmentController extends BaseController {

    @Autowired
    private SysDepartmentService sysDepartmentService;
    @Autowired
    private SysCompanyService sysCompanyService;

    /**
    　* @description:部门列表
    　* @param
    　* @return  
    　* @author geyl
    　* @date 2018-5-22 13:34 
    　*/
    @GetMapping(value = "list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/department/list");
        return modelAndView;
    }

    @GetMapping(value = "page")
    public @ResponseBody
    PageResult<SysDepartment> page(SysDepartment sysDepartment){
        return sysDepartmentService.pageList(sysDepartment) ;
    }
    /**
    　* @description:部门新增
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/department/add");
        modelAndView.addObject("companys", sysCompanyService.selectAll(null));
        return modelAndView;
    }

    /**
     　* @description:部门编辑
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "edit/{departmentId}")
    public ModelAndView edit(ModelAndView modelAndView,@PathVariable String departmentId) {
        modelAndView.setViewName("/system/department/edit");
        modelAndView.addObject("companys", sysCompanyService.selectAll(null));
        modelAndView.addObject("department",sysDepartmentService.selectByPrimaryKey(departmentId));
        return modelAndView;
    }

    /**
     　* @description:新增部门
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @PutMapping(value = "add")
    public @ResponseBody
    Result addDepartment(SysDepartment sysDepartment ) {
        return sysDepartmentService.addDepartment(sysDepartment);
    }

}
