package com.restapitraining.calculator.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hesapmakinesi")
public class Calculator {

    //İki sayıyı toplayan GET endpointi
    @GetMapping("/toplama")
    public int addition(@RequestParam int number1, @RequestParam int number2) {
        return number1 + number2;
    }

    // İki sayıyı toplayan carpma POST endpointi
    @PostMapping("/carpma")
    public int multiplication(@RequestBody int[] numbers) {
        int multiply = 1;
        for (int sayi : numbers) {
            multiply *= sayi;
        }
        return multiply;
    }
}
