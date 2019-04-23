package com.whj.springboot.common;

import lombok.Data;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/23 10:23
 * @Description: 统一的响应格式
 */
@Data
public class BaseResult<T> {

    private String status;

    private String message;

    private Object data;


    public BaseResult(String status, String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> BaseResult<T> success(T data){
        return new BaseResult("0000","操作成功",data);
    }

    public static <T> BaseResult<T> success(){
        return new BaseResult("0000","操作成功");
    }

    public static <T> BaseResult<T> failed(String message){
        return new BaseResult("4000",message);
    }

}
