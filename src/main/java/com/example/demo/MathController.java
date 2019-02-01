package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/calculate")
    public String calculate(Calculate calculate) {
        return calculate.toString();
    }

    @PostMapping("/sum")
    public String sum(@RequestParam(value = "n") Integer[] numArr){
        StringBuilder equation = new StringBuilder();
        int answer = 0;
        for (int i = 0; i < numArr.length; i++) {
            equation.append(numArr[i]);
            answer += numArr[i];
            if(i == numArr.length - 1) {
                equation.append(" = ");
            } else {
                equation.append(" + ");
            }
        }
        equation.append(answer);
        return equation.toString();
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        int volume = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);
    }

    @GetMapping("/pi")
    public String getPi() {
        return "3.141592653589793";
    }

}
