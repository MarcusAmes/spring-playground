package com.example.demo;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @PatchMapping("/people/{peopleId}")
    public String getPerson(@PathVariable String peopleId) {
        return peopleId;
    }
}
