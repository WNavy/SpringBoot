package com.whj.springboot.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/19 11:10
 * @Description: 切面
 */
@Aspect
@Component
@Slf4j
public class MyAspectConfig {

    @Pointcut("execution(public * com.whj.springboot.controller.*.*(..))")
    public void addAdvice(){}

    @Around(value = "addAdvice()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("开始进入增强around方法。。。");
        //获取session信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求路径为：{}",request.getRequestURL().toString());
        log.info("请求参数为：{}", Arrays.toString(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        log.info("返回结果：{}", JSON.toJSON(result));
        return result;
    }

}
