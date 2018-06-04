package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageBean;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysDepartment;
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

    @PostMapping(value = "page")
    public @ResponseBody
    PageBean<SysDepartment> page(@RequestParam(value = "start", defaultValue = "1") int start,
                           @RequestParam(value = "length", defaultValue = "10") int pageSize, SysDepartment sysDepartment) {
        return sysDepartmentService.show(sysDepartment,start,pageSize) ;
    }
    /**
    　* @description:部门新增
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/department/add");
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
    @PutMapping(value = "save")
    public @ResponseBody
    Result save(SysDepartment sysDepartment ) {
        return sysDepartmentService.save(sysDepartment);
    }

}
