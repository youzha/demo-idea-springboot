package com.lin.demoidea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// servlet 注册
// @ServletComponentScan(basePackages = "com.lin.demoidea.moudles.demo2.servlet")
public class DemoIdeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoIdeaApplication.class, args);
    }

}
