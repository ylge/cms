package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageResult;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysCompany;
import com.ehu.service.SysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysCompanyController
 * @Package com.ehu.controller
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

    @PostMapping(value = "page")
    public @ResponseBody
    PageResult<SysCompany> page(SysCompany sysCompany){
        return sysCompanyService.pageList(sysCompany) ;
    }
    /**
    　* @description:公司新增
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/company/add");
        return modelAndView;
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
    Result save(SysCompany sysCompany ){
        return sysCompanyService.save(sysCompany);
    }

}
