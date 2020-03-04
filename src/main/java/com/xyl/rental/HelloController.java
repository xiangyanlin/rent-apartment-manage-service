package com.xyl.rental;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {

    @ResponseBody
    @RequestMapping("")
    public String hello(){
        return  "Hello SpringBoot!";
    }

}
