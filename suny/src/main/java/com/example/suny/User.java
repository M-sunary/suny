package com.example.suny;

import lombok.Data;

/**
 * Created by za-sunyu on 2017/7/6.
 */
@Data
public class User {
    private String userName;
    private Long userId;
    private int age;

    public User(){}

    public User(String userName){
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    };

    public User(Long userId,String userName,int age){
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    };
}
