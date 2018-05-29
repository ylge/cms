package com.ehu.system.controller;

import com.ehu.common.base.BaseController;
import com.ehu.common.bean.PageBean;
import com.ehu.system.entity.SysUser;
import com.ehu.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public String list() {
        return "system/user/list";
    }

    @PostMapping(value = "page")
    public @ResponseBody PageBean<SysUser> page(@RequestParam(value = "start", defaultValue = "1") int start,
                                                @RequestParam(value = "length", defaultValue = "10") int pageSize,SysUser user) {
        return sysUserService.show(user,start,pageSize) ;
    }

    /**
     　* @description:添加用户
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/user/add");
        return modelAndView;
    }

}
