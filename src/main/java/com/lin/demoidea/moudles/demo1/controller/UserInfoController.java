package com.lin.demoidea.moudles.demo1.controller;

import com.lin.demoidea.moudles.demo1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
@RestController
@RequestMapping("v0.1/user_info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/test")
    public Object test() {
        return userInfoService.test();
    }
}
