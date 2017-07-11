package com.suny.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by za-sunyu on 2017/7/10.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model) {
        // 加入一个属性，用来在模板中读取
//        model.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
