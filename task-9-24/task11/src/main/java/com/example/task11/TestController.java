package com.example.task11;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    http://127.0.0.1:8080/actuator/health

    @GetMapping("/test")
    public int test(){
        return 1;
    }
}
