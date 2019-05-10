package com.whj.springboot.exception;

import com.alibaba.fastjson.JSON;
import com.whj.springboot.common.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/28 11:08
 * @Description: springboot提供的全局异常处理(处理error)
 */
@RestController
@Slf4j
public class MyBasicErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @Value("${server.error.path:${error.path:/error}}")
    private static final String path_default = "/error";

    @Override
    public String getErrorPath() {
        return path_default;
    }

    @RequestMapping(value = path_default ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseResult error(HttpServletRequest request) {
        /**
         * springboot2.0之前使用
         * 1、ErrorController引入的包：
         *  org.springframework.boot.autoconfigure.web.ErrorAttributes;
         *  org.springframework.boot.autoconfigure.web.ErrorController;
         *  RequestAttributes requestAttributes = new ServletRequestAttributes(request);
         *  Map<String, Object> body = this.errorAttributes.getErrorAttributes(requestAttributes, true);
         */

        /**
         * springboot2.0以后的用法
         */
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> body = this.errorAttributes.getErrorAttributes(servletWebRequest, true);
        log.info("错误信息：{}",JSON.toJSON(body));
        return BaseResult.failed(body.get("status").toString(),body.get("message").toString());
    }
}
