package com.whj.springboot.exception;

import com.whj.springboot.common.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/26 17:52
 * @Description:全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResult exceptionHandler(Exception ex){
        log.info("1111111111111");
        return BaseResult.failed("1000",ex.getMessage());
    }

    @ExceptionHandler(MyException.class)
    public BaseResult myExceptionHandler(MyException ex){
        log.info("2222222222222");
        return BaseResult.failed("1000",ex.getMessage());
    }
}
