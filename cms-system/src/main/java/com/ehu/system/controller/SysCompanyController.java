package com.ehu.system.controller;

import com.ehu.common.base.BaseController;
import com.ehu.common.bean.entity.system.SysCompany;
import com.ehu.system.service.SysCompanyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        PageInfo<SysCompany> page = sysCompanyService.getCompanyList(null);
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    /**
    　* @description:新增公司
    　* @param
    　* @return  
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/company/add");
        return modelAndView;
    }

}
