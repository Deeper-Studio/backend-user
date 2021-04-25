package com.franklin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {


//shiro
    @RequestMapping({"/index","/"})
    public String toIndex(Model model){
        model.addAttribute("msg","Hello,Please login first");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @RequestMapping("/user/admin")
    public String admin(){
        return "/user/admin";
    }

    @RequestMapping("/user/organization")
    public String organization(){
        return "/user/organization";
    }

    @RequestMapping("/user/staff")
    public String staff(){
        return "/user/staff";
    }

    @RequestMapping("/user/student")
    public String student(){
        return "/user/student";
    }

    @RequestMapping("/user/guest")
    public String guest(){
        return "/user/guest";
    }

   



    @RequestMapping("/login")
    public String login(String username, String password, Model model ){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);//验证成功则返回首页
            return "index";
        }catch (UnknownAccountException e){ //用户名错误
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/toLogin";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "没有相应权限";
    }

}


