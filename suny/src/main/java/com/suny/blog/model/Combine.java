package com.suny.blog.model;

import lombok.Data;

import java.util.List;

@Data
public class Combine {
    private int id;
    private String name;    //套餐名称
    private int combineType;//套餐类型对应 navigation表中navId
    private float price;    //套餐价格
    private String thumbUrl;//套餐展示图片地址
    private List<String> images;    //套餐详情页 图片集合
    private String content; //套餐简述
    private String params;  //套餐相关参数
    private String memo;    //预留字段
}
