package com.suny.blog.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AsirImages {
    private int imagesKey;  //图片key 对应套餐id 或者 案例id
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String image6;
}
