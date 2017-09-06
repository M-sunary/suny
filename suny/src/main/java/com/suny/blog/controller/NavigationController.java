package com.suny.blog.controller;

import com.suny.blog.model.Navigation;
import com.suny.blog.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nav/")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @RequestMapping(value = "lists",method = RequestMethod.GET)
    public List<Navigation> getNavList(){
        List<Navigation> navigationList = navigationService.getNavList();
        return navigationList;
    }

    @RequestMapping(value = "listsByType/{navId}",method = RequestMethod.POST)
    public List<Navigation> getNavListByNavId(@PathVariable String navId) throws Exception{
        if(StringUtils.isEmpty(navId)){
            throw new Exception("请求参数不可为空");
        }
        Navigation navigation = new Navigation();
        navigation.setNavId(Integer.parseInt(navId));
        List<Navigation> navigationList = navigationService.getNavListsByType(navigation);
        return navigationList;
    }
}
