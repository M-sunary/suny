package com.suny.blog.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class AsirCase {
    @NonNull
    private int caseId;
    private String caseIntro;   //案例简介
    private String carType;     //案例车型
    private Date caseTime;      //案例发生时间
    private String optsExpire;  //案例耗费工时
    private String caseThumbUrl;//案例主图
    private String caseRadio;   //案例视频
    private String caseContent; //案例详细介绍
}
