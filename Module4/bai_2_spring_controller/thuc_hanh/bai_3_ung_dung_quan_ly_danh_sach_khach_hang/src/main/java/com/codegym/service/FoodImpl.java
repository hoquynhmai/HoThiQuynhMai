package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class FoodImpl implements Food {
    @Override
    public String save(String food) {
        if(food.equals("")){
            return "Do not leave it blank";
        }
        return "Sandwich Condiments have " + food;
    }
}
