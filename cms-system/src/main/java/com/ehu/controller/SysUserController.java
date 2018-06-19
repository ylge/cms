package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.PageResult;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.service.SysDepartmentService;
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
    @Autowired
    private SysDepartmentService sysDepartmentService;

    @GetMapping(value = "list")
    public String list() {
        return "system/user/list";
    }

    @GetMapping(value = "page")
    public @ResponseBody
    PageResult<SysUser> page(SysUser user){
        return sysUserService.pageList(user) ;
    }

    /**
     　* @description:添加用户
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @GetMapping(value = "add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("/system/user/add");
        modelAndView.addObject("roles",sysRoleService.selectAll(null));
        modelAndView.addObject("departments",sysDepartmentService.selectAll(null));
        return modelAndView;
    }

    /**
     　* @description:新增用户
     　* @param
     　* @return
     　* @author geyl
     　* @date 2018-5-22 13:35
     　*/
    @PostMapping(value = "save")
    public @ResponseBody
    Result save(UserVO userVO ) {
        return sysUserService.save(userVO);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public @ResponseBody
    Result delete(@PathVariable String id){
        sysUserService.deleteByPrimaryKey(id);
        return Result.OK();
    }
}
