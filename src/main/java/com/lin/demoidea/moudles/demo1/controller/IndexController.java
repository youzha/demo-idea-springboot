package com.lin.demoidea.moudles.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljq
 * @create 2019/10/25 0025
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("")
    public Object hello() {
        return "hello";
    }
}
