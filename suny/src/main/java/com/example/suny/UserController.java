package com.example.suny;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by za-sunyu on 2017/7/6.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    //创建线程安全的map
    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public User getUserList(@RequestParam(value = "name") String name){
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        users.put(1l,new User(1l,"suny",27));
        users.put(2l,new User(2l,"臭臭",21));
        users.put(3l,new User(3l,"胖墩",24));
        users.put(4l,new User(4l,"龙虾",26));
        List<User> r = new ArrayList<User>(users.values());
        User us = null;
        for (User u:r){
            if(!StringUtils.isEmpty(name)&&(name).equals(u.getUserName())){
                us = u;
                break;
            }
        }
        return us;
    }

    @RequestMapping(value = "/newUser",method = RequestMethod.POST)
    public String saveNewUser(User user){
        users.put(user.getUserId(),user);
        return "success";
    }
}
