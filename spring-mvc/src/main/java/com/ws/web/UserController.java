package com.ws.web;

import com.ws.entity.User;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @RequestMapping 参数有value、method、params、headers分别表示请求URL、请求方法、请求参数、请求头
 * @RequestParam 绑定请求参数
 * @PathVariable 绑定url中的占位符
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

    /**
     * @PathVariable url中的占位符
     * @param userId
     * @return
     */
    @RequestMapping("/{userId}")
    public ModelAndView showDetail(@PathVariable("userId") String userId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/showDetail");
        modelAndView.addObject("user",userService.showDetail(userId));
        return modelAndView;
    }

    /**
     * 使用请求方法及请求参数映射请求
     * @RequestParam 绑定请求参数
     * @param username
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET,params = "username")
    public String deleteUser(@RequestParam("username") String username){
        userService.deleteUser(username);
        return "/user/deleteSuccess";
    }

    /**
     * 使用RequestBody将请求报文体转换为字符串绑定到requestBody入参中
     * @param requestBody
     * @return
     */
    @RequestMapping("/handle41")
    public String handle41(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "/user/success";
    }

    /**
     * @ResponseBody
     * 读取一张图片，并将图片数据输出到响应流中，客户端将显示这张图片
     * @param imageId
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/handle42/{imageId}")
    public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException{
        System.out.println("load image of "+imageId);
        Resource res = new ClassPathResource("/image.jpg");
        System.out.println(res.getURI()+"---"+res.getURL());
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
        return fileData;
    }
}
