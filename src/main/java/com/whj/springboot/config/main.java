package com.whj.springboot.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whj.springboot.domain.User;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/23 14:41
 * @Description:
 */
public class main {

    public static void main(String[] args) {
        String d = "{\"age\":20,\"id\":\"1\",\"name\":\"tom\",\"school\":{\"address\":\"北京朝阳区\",\"code\":\"bj001\",\"schoolName\":\"北京大学\"},\"sex\":\"boy\"}";

        User user = JSON.parseObject(d,User.class);
        System.out.println(user);
    }
}
