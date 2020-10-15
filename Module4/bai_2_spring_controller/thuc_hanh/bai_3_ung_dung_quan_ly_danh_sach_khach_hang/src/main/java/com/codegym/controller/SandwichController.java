package com.codegym.controller;

import com.codegym.service.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @Autowired
    private Food foodImp;

    @GetMapping("/")
    public String sandwich(){
        return "home";
    }

    @GetMapping("/food")
    public String foodSandwich(@RequestParam String food, Model model) {
        model.addAttribute("food", foodImp.save(food));
        return "home";
    }
}
