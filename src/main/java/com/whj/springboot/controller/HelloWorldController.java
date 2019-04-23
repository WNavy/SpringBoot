package com.whj.springboot.controller;

import com.whj.springboot.common.BaseResult;
import com.whj.springboot.domain.User;
import com.whj.springboot.group.insertGroup;
import com.whj.springboot.group.selectGroup;
import com.whj.springboot.properties.MailProperties;
import com.whj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/19 11:00
 * @Description:
 */
@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @Autowired
    private MailProperties properties;

    @Autowired
    private UserService userService;

    @PostMapping("/mail")
    public BaseResult getMail(){
        return BaseResult.success(properties);
    }

    @PostMapping("/select")
    public BaseResult select(@RequestBody @Validated(value = {selectGroup.class}) User user){
        Object obj = userService.select(user.getId());
        return BaseResult.success(obj);
    }

    @PostMapping("/insert")
    public BaseResult insert(@RequestBody @Validated(value = {insertGroup.class}) User user){
        userService.insert(user);
        return BaseResult.success();
    }
}
