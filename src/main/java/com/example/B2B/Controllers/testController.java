package com.example.B2B.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class testController {
    @GetMapping
    public String returnString(){
        return "hello world";
    }
}
