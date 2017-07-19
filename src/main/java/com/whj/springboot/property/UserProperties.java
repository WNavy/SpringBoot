package com.whj.springboot.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wuhaijun on 2017/7/19.
 */
@Component
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    private  Long id;

    private int age;

    private String name;

    private String uuid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String toString() {
        return "UserProperties{" +
                "id=" + id +
                ", age=" + age +
                ", desc='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
