package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointsController {
    @GetMapping("/")
    public String getIndex() {
        return "GET to index route";
    }

    @PostMapping("/question")
    public String postQuestion() {
        return "Nailed it!";
    }
    @GetMapping("/question")
    public String getQuestion() {
        return "Nailed it!";
    }
    @GetMapping("/hello/world")
    public String helloWorld() {
        return "Hello World!";
    }
    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }
}
