package com.ehu.system.controller;

import com.ehu.common.base.BaseController;
import com.ehu.common.bean.entity.system.SysUser;
import com.ehu.system.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysUserController
 * @Package com.ehoo100.cms.controller.system
 * @Description: 用户管理
 * @date 2018-5-18 13:40
 */
@Controller
@RequestMapping(value = "system/user/")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/user/list");
        PageInfo<SysUser> page = sysUserService.getUserList(null);
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    /**
     　* @description:添加用户
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/user/add");
        return modelAndView;
    }

}
