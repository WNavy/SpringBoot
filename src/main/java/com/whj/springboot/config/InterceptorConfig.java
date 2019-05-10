package com.whj.springboot.config;


import com.whj.springboot.interceptor.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: wuhaijun
 * @Date: 2019/5/5 15:23
 * @Description:注册拦截器到spring容器中
 */
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
        //配置拦截路径
        registration.addPathPatterns("/**");
        //配置不拦截的路径
        registration.excludePathPatterns("/**.html");

        //可以注册多个拦截器，拦截顺序与注册顺序相同

    }
}
