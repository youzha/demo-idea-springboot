package com.lin.demoidea.config;

import com.lin.demoidea.common.security.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
*/

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
/*@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证*/
public class SecurityConfig
       // extends WebSecurityConfigurerAdapter
{
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

  /*  @Autowired
     private MyUserDetailsService myUserDetailsService;

    @Override
    public void init(WebSecurity web) throws Exception {
        //有些跨域请求会使用options测试服务端性能
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");

        super.init(web);
    }
    @Override
    public void configure(WebSecurity web) {
        String[] ignores = new String[]{"/*.png", "/*.html", "/*.js", "/styles/**", "/", "/data/**", "/home/**"};
        web.ignoring().antMatchers(ignores);
        logger.info("web security ignoring: " + Arrays.toString(ignores));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  允许所有用户访问"/"和"/index.html"
                 http.authorizeRequests()
                         .anyRequest().permitAll();// 暂时允许所有请求
                         *//*.antMatchers("/", "/index.html").permitAll()
                         .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                         .and()
                         .formLogin()
                         .loginPage("/login.html")   //  登录页
                         .failureUrl("/error.html").permitAll()
                         .and()
                         .logout()
                         .logoutSuccessUrl("/index.html");*//*
    }
*/
}
