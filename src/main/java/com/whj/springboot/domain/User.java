package com.whj.springboot.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.whj.springboot.group.insertGroup;
import com.whj.springboot.group.selectGroup;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/22 10:46
 * @Description:
 */
@Data
public class User implements Serializable {

    public User(){}

    public User(String id,String name,int age,String sex){
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @NotNull(message = "编号不能为空",groups = {insertGroup.class,selectGroup.class})
    private String id;

    @NotNull(message = "名字不能为空",groups = {insertGroup.class})
    private String name;

    @NotNull(message = "年龄不能为空")
    private int age;

    @NotNull(message = "性别不能为空")
    private String sex;

    /**
     * @DateTimeFormat:针对入参，将字符串转换成时间,是spirng提供的,入参的格式要与patten指定的格式一致
     * @JsonFormat:针对出参，将时间格式转换成字符串，使用该注解需要指定timezone,该注解也是spring提供的
     * @JSONField:针对出参，将字段转换成要显示的字符串格式
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(message = "学校不能为空")
    @Valid
    private List<School> schools;
}
