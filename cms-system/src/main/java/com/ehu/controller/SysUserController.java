package com.ehu.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.ehu.base.BaseController;
import com.ehu.bean.PageResult;
import com.ehu.bean.Result;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.service.SysDepartmentService;
import com.ehu.service.SysRoleService;
import com.ehu.service.SysUserService;
import com.ehu.util.DateUtil;
import com.ehu.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("system/user/list");
        return modelAndView;
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
//    @Log(desc="新增用户")
    @PostMapping(value = "add")
    public @ResponseBody
    Result addUser(UserVO userVO ) {
        return sysUserService.addUser(userVO);
    }

    @PostMapping(value = "update")
    public @ResponseBody
    Result update(UserVO userVO ) {
        return sysUserService.updateUser(userVO);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public @ResponseBody
    Result delete(@PathVariable String id){
        return sysUserService.deleteUser(id);
    }

    /**
     * excel导出
     */
    @GetMapping(value = "userExport")
    public void exportExcel(ModelMap modelMap, HttpServletRequest request,
                            HttpServletResponse response) {
        ExportParams params = new ExportParams("用户信息", null, ExcelType.XSSF);
        modelMap.put(NormalExcelConstants.DATA_LIST, sysUserService.selectAll(null));
        modelMap.put(NormalExcelConstants.CLASS, SysUser.class);
        modelMap.put(NormalExcelConstants.PARAMS, params);
        String fileName = DateUtil.dateFormat(new Date(), DateUtil.DATE_TIME_PATTERN);
        modelMap.put(NormalExcelConstants.FILE_NAME, "用户信息表:" + fileName);
        PoiBaseView.render(modelMap, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
}
