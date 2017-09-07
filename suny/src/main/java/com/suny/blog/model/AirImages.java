package com.suny.blog.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AirImages {
    @NonNull
    private int imageKey;   //图片key:根据image_type对应套餐id 或 案例id
    @NonNull
    private int inageType;  //图片类型：1=>套餐图；2=>案例图
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
}
