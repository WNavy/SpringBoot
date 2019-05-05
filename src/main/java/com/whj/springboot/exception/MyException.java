package com.whj.springboot.exception;

import lombok.Data;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/26 17:46
 * @Description:自定义异常
 */
@Data
public class MyException extends Exception  {

    public MyException(String message){
       super(message);
    }
}
