package com.suny.blog.controller;

import com.suny.blog.model.Banner;
import com.suny.blog.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banner/")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Banner> getCMList(){
        List<Banner> bannerList = bannerService.getBannerList();
        return bannerList;

    }
}
