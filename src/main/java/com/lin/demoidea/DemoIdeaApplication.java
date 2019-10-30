package com.lin.demoidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// servlet 注册
// @ServletComponentScan(basePackages = "com.lin.demoidea.moudles.demo2.servlet")
public class DemoIdeaApplication {

    public static void main(String[] args) {
        //ConfigurableApplicationContext context =
                SpringApplication.run(DemoIdeaApplication.class, args);
        //context.getBean("");
        //关闭上下文
        // context.close();
    }

}
