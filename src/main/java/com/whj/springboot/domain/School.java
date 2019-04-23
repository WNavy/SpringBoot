package com.whj.springboot.domain;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/22 13:55
 * @Description:
 */
@Data
public class School {

    private String code;

    @NotNull(message = "学校名称不能为空")
    private String schoolName;

    private String address;
}
