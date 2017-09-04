package com.suny.blog.controller;

import com.suny.blog.model.Navigation;
import com.suny.blog.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nav/")
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Navigation> getNavList(){
        List<Navigation> navigationList = navigationService.getNavList();
        return navigationList;
    }
}
