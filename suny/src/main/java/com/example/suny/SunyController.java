package com.example.suny;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by za-sunyu on 2017/7/5.
 */

@RestController
public class SunyController {
    private static final String template = "Hello , %s !";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/say")
    public Suny say(@RequestParam(value = "name" ,defaultValue="World") String name){
        System.out.println(String.format(template,name));
        return new Suny(counter.incrementAndGet(),String.format(template,name));
    }
}
