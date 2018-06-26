package com.suny.blog.service;

import com.suny.blog.model.UserBaseInfo;

/**
 * 【用户业务处理接口】模块
 *
 * @author yu.sun
 * @content 用户业务处理接口
 * @date 2018/4/8 16:27
 */
public interface UserService {
    public UserBaseInfo getUserById(int userId);
}
