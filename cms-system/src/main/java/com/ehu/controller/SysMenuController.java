package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.Result;
import com.ehu.bean.TreeGridNode;
import com.ehu.bean.TreeGridWrapper;
import com.ehu.bean.entity.system.SysMenu;
import com.ehu.service.SysMenuService;
import com.ehu.service.TreeGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单管理
　* @author geyl
　* @date 2018-5-18 13:15
　*/
@Controller
@RequestMapping("system/menu/")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService menuService;
    @Autowired
    private TreeGridService treeGridService;

    /**
     * 菜单列表
     * @param modelAndView
     * @return
     */
    @GetMapping(value = "list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/system/menu/list");
        return modelAndView;
    }

    /**
     * 新增菜单
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping(value = "add/{id}")
    public ModelAndView add(@PathVariable String id, ModelAndView modelAndView){
        modelAndView.setViewName("/system/menu/add");
        modelAndView.addObject("menu",menuService.selectByPrimaryKey(id));
        return modelAndView;
    }

    /**
     * 保存菜单
     * @param menu
     * @return
     */
    @PutMapping(value = "save")
    public @ResponseBody
    Result save(SysMenu menu){
        return menuService.save(menu);
    }

    /**
     * 编辑菜单
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView edit(@PathVariable String id, ModelAndView modelAndView){
        SysMenu menu = menuService.selectByPrimaryKey(id);
        modelAndView.addObject("menu",menu);
        modelAndView.setViewName("/system/menu/edit");
        return modelAndView;
    }

    @GetMapping(value = "getTreeGridMenu")
    public @ResponseBody
    TreeGridWrapper getTreeGridMenu(){
        List<TreeGridNode> list = treeGridService.getMenuTreeGridNodes();
        TreeGridWrapper wrapper = new TreeGridWrapper();
        wrapper.setRows(list);
        wrapper.setTotal(list.size());
        return wrapper;
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public @ResponseBody
    Result delete(@PathVariable String id){
        menuService.deleteByPrimaryKey(id);
        return Result.OK();
    }
}