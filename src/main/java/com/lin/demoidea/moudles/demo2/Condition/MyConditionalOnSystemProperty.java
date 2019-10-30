package com.lin.demoidea.moudles.demo2.Condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author: ljq
 * @Description: 自定义条件装配--编程方式 实现根据系统参数条件判断装配
 * @Date: 2019/10/30 0030 下午 09:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(MyOnSystemPropertyCondition.class)
public @interface MyConditionalOnSystemProperty {
    String myName();
    String myValue();
}
