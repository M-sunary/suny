package com.suny.blog.controller;

import com.suny.blog.model.UserBaseInfo;
import com.suny.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by za-sunyu on 2017/7/10.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model){
        // 加入一个属性，用来在模板中读取
//        model.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        UserBaseInfo userBaseInfo = userService.getUserById(1);
        System.out.println("当前用户的自我简介："+userBaseInfo.getUserIntroduce());
        return "index";
    }

    @RequestMapping("/hello")
    public String Hello() throws Exception {
        throw new Exception("发生错误");
    }
}
