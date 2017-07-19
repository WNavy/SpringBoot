package com.whj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2017/7/18.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
