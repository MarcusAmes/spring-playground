package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @PostMapping("/comments")
    public String getFormData() {

        return "";
    }
}
