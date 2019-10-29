package com.lin.demoidea.common.security.controller;

import com.lin.demoidea.common.security.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ljq
 * @create 2019/10/28 0028
 */
@RestController
public class DefaultController {

   /* @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }*/
   @GetMapping("/test/test")
    public String test() {
       return "test success";
   }
   @PostMapping("/login")
    public Object login(SysUser sysUser) {
       return sysUser;
   }
}
