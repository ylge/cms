package com.ehu.system.controller;

import com.ehu.common.base.BaseController;
import com.ehu.common.bean.Result;
import com.ehu.system.entity.SysCompany;
import com.ehu.system.service.SysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysCompanyController
 * @Package com.ehoo100.cms.controller.system
 * @Description: 公司管理
 * @date 2018-5-18 13:40
 */
@Controller
@RequestMapping(value = "system/company/")
public class SysCompanyController extends BaseController {

    @Autowired
    private SysCompanyService sysCompanyService;

    /**
    　* @description:公司列表
    　* @param
    　* @return  
    　* @author geyl
    　* @date 2018-5-22 13:34 
    　*/
    @GetMapping(value = "list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/company/list");
        return modelAndView;
    }

    /**
    　* @description:公司新增
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @GetMapping(value = "add")
    public String add() {
        return "/system/company/add";
    }

    /**
     　* @description:公司编辑
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "edit/{companyId}")
    public ModelAndView edit(ModelAndView modelAndView,@PathVariable String companyId) {
        modelAndView.setViewName("/system/company/edit");
        modelAndView.addObject("company",sysCompanyService.selectByPrimaryKey(companyId));
        return modelAndView;
    }

    /**
     　* @description:新增公司
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @PutMapping(value = "save")
    public @ResponseBody
    Result save(@RequestBody SysCompany sysCompany ) {
        if(sysCompanyService.save(sysCompany)){
            return Result.OK();
        }else {
            return Result.Fail();
        }

    }

}
