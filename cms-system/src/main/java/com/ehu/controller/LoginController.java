package com.ehu.controller;

import com.ehu.base.BaseController;
import com.ehu.bean.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 *@Auther: geyl
 *@Date: 2018/5/8
 *@Description
 */
@Controller
public class LoginController extends BaseController {
    /**
     * 进入登录页面
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView getLogin(ModelAndView modelAndView){
        modelAndView.setViewName("/system/login");
        return modelAndView;
    }
    @RequestMapping(value = {"/postLogin"}, method = RequestMethod.POST)
    public String postLogin(@RequestParam(required = true) String username, @RequestParam(required = true) String password, ModelAndView modelAndView, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password.toCharArray());
        try {
            subject.login(token);
            ShiroUser user = (ShiroUser) subject.getPrincipal();
            modelAndView.addObject("user",user);
            session.setAttribute("user",user);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return REDIRECT + "/";
    }
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(){
        SecurityUtils.getSubject().logout();
        return REDIRECT + "/";
    }
}
