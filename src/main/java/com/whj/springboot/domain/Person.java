package com.whj.springboot.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wuhaijun
 * @Date: 2019/5/9 09:20
 * @Description: 用户信息
 */
@Data
public class Person {

    private Integer id;

    private String name;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    private String address;
}
