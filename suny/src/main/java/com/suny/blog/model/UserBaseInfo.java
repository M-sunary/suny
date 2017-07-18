package com.suny.blog.model;

import lombok.Data;

/**
 * Created by za-sunyu on 2017/7/6.
 */
@Data
public class UserBaseInfo {
    private String userName;
    private Integer userId;
    private String userIntroduce;
    private String navImg;
    private String usesrAdreess;
    private String email;
    private String userMotto;
    private Float yearOfWorks;
    private String avatarImg;

    public UserBaseInfo(){}

    public UserBaseInfo(String userName){
        this.userId = userId;
        this.userName = userName;
    };

    public UserBaseInfo(Integer userId,String userName){
        this.userId = userId;
        this.userName = userName;
    };
}
