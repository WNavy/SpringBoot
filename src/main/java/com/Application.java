package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wuhaijun
 * springboot的启动入口，要放在所有所有的RestController的根路径的package下
 * CommandLineRunner中的run()方法，在应用程序启动之前首先被调用
 */
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        System.out.println("###springboot启动成功###");
    }

    @Override
    public void run(String... strings) {
        log.info("启动之后，先打印时间 :{}",System.currentTimeMillis());
    }
}
