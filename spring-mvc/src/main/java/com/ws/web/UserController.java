package com.ws.web;

import com.ws.entity.User;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alvin on 2016/5/29.
 */
@Controller //使UserController成为控制器
@RequestMapping("/user") //处理来自/user URI的请求
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")//返回一个ModelAndView
    public String register(){
        return "/user/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(User user){
        userService.createUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
