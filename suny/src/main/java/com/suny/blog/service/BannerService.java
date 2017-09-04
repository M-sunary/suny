package com.suny.blog.service;

import com.suny.blog.model.Banner;

import java.util.List;

public interface BannerService {

    public List<Banner> getBannerList();
    public void updateBanner(Banner banner);
}
