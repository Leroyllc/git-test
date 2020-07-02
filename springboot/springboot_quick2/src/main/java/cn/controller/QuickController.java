package cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quick2")
public class QuickController {

    @Value("${name}")
    private String name;

    @RequestMapping("/quick2")
    @ResponseBody
    public String quick2(){
        System.out.println(name);
        return "nihao quick2";
    }
}
