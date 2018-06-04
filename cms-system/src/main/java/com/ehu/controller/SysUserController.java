package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageBean;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.service.SysRoleService;
import com.ehu.service.SysUserService;
import com.ehu.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author geyl
 * @Title: SysUserController
 * @Package com.ehu.controller
 * @Description: 用户管理
 * @date 2018-5-18 13:40
 */
@Controller
@RequestMapping(value = "system/user/")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

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
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/user/add");
        modelAndView.addObject("roles",sysRoleService.selectAllRole());
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
    Result save(UserVO userVO ) {
        return sysUserService.save(userVO);
    }

}
