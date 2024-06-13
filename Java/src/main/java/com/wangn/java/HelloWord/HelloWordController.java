package com.wangn.java.HelloWord;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello world!";
    }
}