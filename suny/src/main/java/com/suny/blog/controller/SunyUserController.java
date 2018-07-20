package com.suny.blog.controller;

import com.suny.blog.model.UserBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by yu.sun on 2017/7/6.
 */
@Api(description = "用户操作接口")
@RestController
@RequestMapping(value = "/users")
public class SunyUserController {
    private Logger logger = LoggerFactory.getLogger(SunyUserController.class);
    //创建线程安全的map
    static Map<Integer,UserBaseInfo> users = Collections.synchronizedMap(new HashMap<Integer,UserBaseInfo>());


    @ApiOperation(value = "用户列表接口")
    @RequestMapping(value = "/user_list",method = RequestMethod.GET)
    public UserBaseInfo getUserList(@RequestParam(value = "name") String name){
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        users.put(1,new UserBaseInfo(1,"suny"));
//        users.put(2l,new User(2l,"臭臭",21));
//        users.put(3l,new User(3l,"胖墩",24));
//        users.put(4l,new User(4l,"龙虾",26));
        List<UserBaseInfo> r = new ArrayList<UserBaseInfo>(users.values());
        UserBaseInfo us = null;
        for (UserBaseInfo u:r){
            if(!StringUtils.isEmpty(name)&&(name).equals(u.getUserName())){
                us = u;
                break;
            }
        }
        return us;
    }


    @RequestMapping(value = "/new_user",method = RequestMethod.POST)
    public String saveNewUser(UserBaseInfo user){
        users.put(user.getUserId(),user);
        return "success";
    }

}
