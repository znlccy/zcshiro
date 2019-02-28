package com.znlccy.zcshiro.controller;

import com.znlccy.zcshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-12:10
 * version: 1.0.0
 * comment: 用于控制器
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 自动依赖注入用户服务
     */
    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/unAuth")
    public String unAuth() {
        return "unAuth";
    }

    /**
     * 处理用户登录
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model) {
        System.out.println("username =" + username);
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject  subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功
            //跳转到注册页面
            return "redirect:/user/register";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败
            model.addAttribute("msg","用户不存在");
            return "login";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    /**
     * 用户添加接口
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    /**
     * 用户编辑接口
     * @return
     */
    @RequestMapping("/edit")
    public String edit() {
        return "user/edit";
    }

    /**
     * 用户注册接口
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("name", "黑马程序员");
        return "register";
    }
}
