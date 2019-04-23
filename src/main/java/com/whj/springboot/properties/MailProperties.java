package com.whj.springboot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/17 17:37
 * @Description:
 */
@Component
@PropertySource(value = "classpath:/mail.properties")
@ConfigurationProperties(prefix = "mail")
@Data
public class MailProperties {

    private String host;

    private String port;

    private String loginName;

    private String password;
}
