package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageResult;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysRole;
import com.ehu.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysRoleController
 * @Package com.ehu.controller
 * @Description: 角色管理
 * @date 2018-5-18 13:40
 */
@Controller
@RequestMapping(value = "system/role/")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
    　* @description:角色列表
    　* @param
    　* @return  
    　* @author geyl
    　* @date 2018-5-22 13:34 
    　*/
    @GetMapping(value = "list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/role/list");
        return modelAndView;
    }

    @PostMapping(value = "page")
    public @ResponseBody
    PageResult<SysRole> page(SysRole sysRole) {
        return sysRoleService.pageList(sysRole) ;
    }
    /**
    　* @description:角色新增
    　* @author geyl
    　* @date 2018-5-22 13:35 
    　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/role/add");
        return modelAndView;
    }

    /**
     　* @description:角色编辑
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "edit/{roleId}")
    public ModelAndView edit(ModelAndView modelAndView,@PathVariable String roleId) {
        modelAndView.setViewName("/system/role/edit");
        modelAndView.addObject("role",sysRoleService.selectByPrimaryKey(roleId));
        return modelAndView;
    }

    /**
     　* @description:新增角色
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @PutMapping(value = "save")
    public @ResponseBody
    Result save(SysRole sysrole ){
        return sysRoleService.save(sysrole);
    }

}
