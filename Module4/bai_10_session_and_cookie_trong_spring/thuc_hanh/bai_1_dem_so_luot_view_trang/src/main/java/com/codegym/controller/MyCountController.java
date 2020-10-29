package com.codegym.controller;

import com.codegym.entity.MyCount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myCount")
public class MyCountController {

    @ModelAttribute("myCount")
    public MyCount setUpCounter() {
        return new MyCount();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("myCount") MyCount myCount) {
        myCount.increment();
        return "home";
    }
}
