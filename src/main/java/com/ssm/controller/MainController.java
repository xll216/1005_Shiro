package com.ssm.controller;

import com.ssm.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class MainController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/unauthor")
    public String unauthor() {
        return "unauthor";
    }

    /**
     * 跳转到登录页面
     * 在需要认证的时候进入的页面
     **/
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 处理登录表单，执行shiro认证
     **/
    @RequestMapping("/submitLogin")
    public String submitLogin(User user) {
        System.out.println("表单提交的参数为：" + user);

        //shiro认证
        /*1,获得当前的Subject用户对象*/
        Subject currentUser = SecurityUtils
                .getSubject();

        System.out.println("当前用户对象：" + currentUser);

        /*2,创建用户名/密码的token令牌*/
        UsernamePasswordToken token = new
                UsernamePasswordToken(
                user.getUserName(),
                user.getPassword());

        /*3,执行shiro认证*/
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("认证失败返回登录界面");
            return "login";
        }

        return "home";
    }


    /**
     * 退出登录
     **/
    @RequestMapping("/logout")
    public String logout() {
        /*1,获得当前的用户对象*/
        Subject currentUser = SecurityUtils
                .getSubject();

        /*2,退出登录*/
        currentUser.logout();

        return "login";
    }

}
