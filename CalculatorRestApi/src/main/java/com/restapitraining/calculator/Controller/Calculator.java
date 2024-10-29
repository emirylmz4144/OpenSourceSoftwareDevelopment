package com.restapitraining.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hesapmakinesi")
public class Calculator {

    //İki sayıyı toplayan GET endpointi
    @GetMapping("/toplama")
    public int addition(@RequestParam int number1, @RequestParam int number2) {
        return number1 + number2;
    }
}
