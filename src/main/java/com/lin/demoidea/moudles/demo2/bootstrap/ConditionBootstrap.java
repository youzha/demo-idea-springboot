package com.lin.demoidea.moudles.demo2.bootstrap;

import com.lin.demoidea.moudles.demo2.Condition.MyConditionalOnSystemProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author ljq
 * @create 2019/10/30 0030
 */
//@SpringBootApplication(scanBasePackages="com.lin.demoidea.moudles.demo2")
public class ConditionBootstrap {
    @Bean
    @MyConditionalOnSystemProperty(myName="user.name", myValue="ljq")
    public String helloL() {
        return "hello lin";
    }

    @Bean
    @MyConditionalOnSystemProperty(myName="user.name", myValue="Administrator")
    public String helloA() {
        return "hello Administrator";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        //String hello = context.getBean("helloL", String.class);

        String hello = context.getBean("helloA", String.class);
        System.out.println(hello);
        context.close();
    }
}
