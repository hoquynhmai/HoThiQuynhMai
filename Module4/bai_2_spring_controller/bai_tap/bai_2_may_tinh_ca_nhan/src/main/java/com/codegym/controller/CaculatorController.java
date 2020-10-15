package com.codegym.controller;

import com.codegym.service.Caculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private Caculate caculateImp;

    @GetMapping("/")
    public String caculator(){
        return "home";
    }

    @GetMapping("/result")
    public String caculateMath(@RequestParam String caculate, double num1, double num2, Model model){
        model.addAttribute("caculate", caculateImp.caculate(num1, num2, caculate));
        return "home";
    }
}
