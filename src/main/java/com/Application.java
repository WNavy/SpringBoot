package com;

import com.whj.springboot.property.HelloProperties;
import com.whj.springboot.property.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wuhaijun on 2017/6/7.
 *
 * springboot的启动入口，要放在所有所有的RestController的根路径的package下
 * CommandLineRunner中的run()方法，在应用程序启动之后首先被调用
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private HelloProperties helloProperties;
    @Autowired
    private UserProperties userProperties;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(helloProperties.toString());
        System.out.println(userProperties.toString());
    }
}
