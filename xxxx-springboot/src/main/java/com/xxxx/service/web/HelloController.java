package com.xxxx.service.web;

import com.xxxx.service.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String print(){
        return "Hello World";
    }

    @RequestMapping(value="/error",method= RequestMethod.GET)
    public String errorJson()throws MyException{
        throw new MyException("获取json出现异常");
    }
}
