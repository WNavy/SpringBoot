package com.whj.springboot.domain;

import com.whj.springboot.group.insertGroup;
import com.whj.springboot.group.selectGroup;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/22 10:46
 * @Description:
 */
@Data
public class User {

    @NotNull(message = "编号不能为空",groups = {insertGroup.class,selectGroup.class})
    private String id;

    @NotNull(message = "名字不能为空",groups = {insertGroup.class})
    private String name;

    @NotNull(message = "年龄不能为空")
    private int age;

    @NotNull(message = "性别不能为空")
    private String sex;

    @NotNull(message = "学校不能为空")
    @Valid
    private School school;
}
