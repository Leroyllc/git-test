package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello SpringMvc");
        return "success";
    }

    @RequestMapping("/request")
    public String testRequest(){
        System.out.println("request");
        return "success";
    }
}
