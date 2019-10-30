package com.lin.demoidea.moudles.demo2.Condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author ljq
 * @create 2019/10/30 0030
 */
public class MyOnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 取@MyConditionalOnSystemProperty里面的属性名-属性 的map
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionalOnSystemProperty.class.getName());
        // 取属性
        String propertyName = String.valueOf(annotationAttributes.get("myName"));
        String propertyValue = String.valueOf(annotationAttributes.get("myValue"));

        //取系统的属性
        String  javaPropertyValue = System.getProperty(propertyName);

        // 判断属性是否和系统属性一致，一致则返回true，表示允许装配
        return propertyValue.equals(javaPropertyValue);
    }
}
