package com.whj.springboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.whj.springboot.domain.User;
import com.whj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/22 10:48
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Object select(String id) {
        String s = JSON.toJSONString(redisTemplate.opsForValue().get(id));
        User user = JSON.parseObject(s,User.class);
        return user;
    }

    @Override
    public void insert(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }
}
