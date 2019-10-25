package com.lin.demoidea.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
// @Configuration
public class DataSourceConfig {
// 配置两个数据源的方法:https://www.abboke.com/jsh/2019/0719/9253.html

    /*@Bean(name = "primaryDataSource")
    @Primary
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource primaryDataSource() {
        System.out.println("-------------------- primaryDataSource初始化 ---------------------");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource secondaryDataSource() {
        System.out.println("-------------------- secondaryDataSource初始化---------------------");
        return DataSourceBuilder.create().build();
    }*/
}
