package com.suny.blog.controller;

import com.suny.blog.model.Combine;
import com.suny.blog.service.CombineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/combine/")
public class CombineController {

    @Autowired
    private CombineService combineService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Combine> getCMList(){
        List<Combine> cmbList = combineService.getCombineList();
        return cmbList;

    }
}
