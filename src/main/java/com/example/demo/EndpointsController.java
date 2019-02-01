package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/vehicles")
    public String getVehicle(@RequestParam(value = "doors", defaultValue = "4") String doors, @RequestParam String year) {
        return year + doors;
    }

    @GetMapping("/cars")
    public String getCar(@RequestParam Map querystring) {
        return querystring.toString();
    }
}
